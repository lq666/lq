package cn.sz.gl.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter extends HandlerInterceptorAdapter {

	private static String [] urls = {"uc/islogin"};
	
	public boolean checkUrl(String requestname){
		for (int i = 0; i < urls.length; i++) {
			if(urls[i].equals(requestname)){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 业务方法执行之前，适配器适配成功之后 开始执行，返回一个布尔值
	 * 如果返回true,表示拦截器通过拦截，可以正常访问业务方法
	 * 如果返回false,表示拦截器阻止请求，此时不再执行业务方法
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("1.执行preHandle方法");
		//这里，所有请求都会进入这里，包括请求的静态资源(*.js,*.jpg,*.css.....)
		
		//这里来判断是否登录过，如果已经登录，那么返回true,如果没有登录过，跳转到登录页并返回false
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("users");
		
		//获取当前请求的名字
		String uri = request.getRequestURI();
		String contextpath = request.getContextPath();
		System.out.println("uri:"+uri);
		System.out.println("contextpath:"+contextpath);
		
		String requestname = uri.substring(contextpath.length()+1, uri.length());
		System.out.println("requestname:"+requestname);
		
		if(obj==null){
			//表示没有登录过
			
			//这里，还需要判断当前的请求的名字，某些请求就算没登录也要放过
			if(this.checkUrl(requestname)){
				return true;
			}
			
			response.sendRedirect("login.jsp");
			return false;
		}
		//已经登录过
		//这里，还可以进行权限验证
		
		return true;
		
		
		
		
	}
	
	/**
	 * 业务方法执行完毕之后运行，
	 * preHandle方法返回为true的时候才会执行
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("2.业务方法执行完毕之后执行，postHandle....");
	}
	
	/**
	 * 请求处理完毕之后再执行，主要用来释放资源等
	 * 也只有在preHandle方法返回true的时候才会执行
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("请求处理完毕时执行，afterCompletion.....");
	}
	
}
