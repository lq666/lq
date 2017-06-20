package cn.sz.gl.control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sz.gl.pojo.Book;
import cn.sz.gl.service.IBookService;

@Controller
@RequestMapping("/")
public class MainController {

	private IBookService bookServiceImpl;
	
	@RequestMapping(value="/")
	public String firstpage(Model model){
		System.out.println("½øÈëÊ×Ò³....");
		List<Book> booklist = bookServiceImpl.findall();
		model.addAttribute("booklist", booklist);
		return "main";
	}

	public IBookService getBookServiceImpl() {
		return bookServiceImpl;
	}

	public void setBookServiceImpl(IBookService bookServiceImpl) {
		this.bookServiceImpl = bookServiceImpl;
	}
	
}
