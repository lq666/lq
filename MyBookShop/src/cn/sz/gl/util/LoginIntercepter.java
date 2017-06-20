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
	 * ҵ�񷽷�ִ��֮ǰ������������ɹ�֮�� ��ʼִ�У�����һ������ֵ
	 * �������true,��ʾ������ͨ�����أ�������������ҵ�񷽷�
	 * �������false,��ʾ��������ֹ���󣬴�ʱ����ִ��ҵ�񷽷�
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("1.ִ��preHandle����");
		//����������󶼻���������������ľ�̬��Դ(*.js,*.jpg,*.css.....)
		
		//�������ж��Ƿ��¼��������Ѿ���¼����ô����true,���û�е�¼������ת����¼ҳ������false
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("users");
		
		//��ȡ��ǰ���������
		String uri = request.getRequestURI();
		String contextpath = request.getContextPath();
		System.out.println("uri:"+uri);
		System.out.println("contextpath:"+contextpath);
		
		String requestname = uri.substring(contextpath.length()+1, uri.length());
		System.out.println("requestname:"+requestname);
		
		if(obj==null){
			//��ʾû�е�¼��
			
			//�������Ҫ�жϵ�ǰ����������֣�ĳЩ�������û��¼ҲҪ�Ź�
			if(this.checkUrl(requestname)){
				return true;
			}
			
			response.sendRedirect("login.jsp");
			return false;
		}
		//�Ѿ���¼��
		//��������Խ���Ȩ����֤
		
		return true;
		
		
		
		
	}
	
	/**
	 * ҵ�񷽷�ִ�����֮�����У�
	 * preHandle��������Ϊtrue��ʱ��Ż�ִ��
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("2.ҵ�񷽷�ִ�����֮��ִ�У�postHandle....");
	}
	
	/**
	 * ���������֮����ִ�У���Ҫ�����ͷ���Դ��
	 * Ҳֻ����preHandle��������true��ʱ��Ż�ִ��
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("���������ʱִ�У�afterCompletion.....");
	}
	
}
