package cn.sz.gl.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sz.gl.pojo.StoreHouse;
import cn.sz.gl.service.IStoreHouseService;

@Controller
@RequestMapping("shc")
public class StoreHouseController {

	private IStoreHouseService storeHouseServiceImpl;
	
	@RequestMapping(value="showbookinfo")
	public String showBookInfo(Integer bookid,Model model){
		//int bookCount = storeHouseServiceImpl.findBookCountByBookid(bookid);
		StoreHouse sh = storeHouseServiceImpl.findStoreHouseByBookid(bookid);
		model.addAttribute("sh", sh);
		return "pages/bookinfo";
	}
	
	@RequestMapping(value="paymoney",method=RequestMethod.POST)
	public String paymoney(Integer bookid,Integer accid,Model model){
		
		boolean flag = storeHouseServiceImpl.buyOneBook(bookid, accid);
		String msg = "¹ºÂòÊ§°Ü";
		if(flag){
			msg = "¹ºÂò³É¹¦";
		}
		model.addAttribute("msg", msg);
		return "pages/suc";
	}
	

	public IStoreHouseService getStoreHouseServiceImpl() {
		return storeHouseServiceImpl;
	}

	public void setStoreHouseServiceImpl(IStoreHouseService storeHouseServiceImpl) {
		this.storeHouseServiceImpl = storeHouseServiceImpl;
	}
}
