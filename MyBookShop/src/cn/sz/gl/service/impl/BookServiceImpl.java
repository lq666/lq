package cn.sz.gl.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sz.gl.dao.IBookDAO;
import cn.sz.gl.pojo.Book;
import cn.sz.gl.service.IBookService;
@Service
public class BookServiceImpl implements IBookService {

	private IBookDAO bookDAOImpl;
	
	@Override
	public List<Book> findall() {
		return bookDAOImpl.findall();
	}
	
	@Override
	public Book findBookById(Integer bookid) {
		return bookDAOImpl.findBookById(bookid);
	}
	
	
	
	
	

	public IBookDAO getBookDAOImpl() {
		return bookDAOImpl;
	}

	public void setBookDAOImpl(IBookDAO bookDAOImpl) {
		this.bookDAOImpl = bookDAOImpl;
	}



}
