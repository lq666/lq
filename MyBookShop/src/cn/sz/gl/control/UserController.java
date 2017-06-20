package cn.sz.gl.control;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sz.gl.pojo.Users;
import cn.sz.gl.service.IUserService;

@Controller
@RequestMapping("uc")
public class UserController {
	
	private IUserService userServiceImpl;

	@RequestMapping(value="islogin",method=RequestMethod.POST)
	public String islogin(Users users,HttpSession session){
		Users u = userServiceImpl.islogin(users);
		if(u==null){
			//µÇÂ¼Ê§°Ü
			return "login";
		}
		//³É¹¦
		session.setAttribute("users", u);
		return "redirect:/";
	}

	public IUserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(IUserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
}
