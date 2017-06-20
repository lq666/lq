package cn.sz.gl.control;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sz.gl.pojo.Account;
import cn.sz.gl.pojo.Book;
import cn.sz.gl.pojo.Users;
import cn.sz.gl.service.IAccountService;
import cn.sz.gl.service.IBookService;

@Controller
@RequestMapping("ac")
public class AccountController {

	private IAccountService accountServiceImpl;
	private IBookService bookServiceImpl;
	
	@RequestMapping(value="showAccInfo")
	public String showMyAccountInfo(Integer bookid,HttpSession session,Model model){
		
		Users u = (Users) session.getAttribute("users");
		List<Account> acclist = accountServiceImpl.findMyAccInfo(u.getUserid());
		Book book = bookServiceImpl.findBookById(bookid);
		model.addAttribute("acclist", acclist);
		model.addAttribute("book", book);
		return "pages/myorder";
	}

	public IAccountService getAccountServiceImpl() {
		return accountServiceImpl;
	}

	public void setAccountServiceImpl(IAccountService accountServiceImpl) {
		this.accountServiceImpl = accountServiceImpl;
	}

	public IBookService getBookServiceImpl() {
		return bookServiceImpl;
	}

	public void setBookServiceImpl(IBookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}
}
