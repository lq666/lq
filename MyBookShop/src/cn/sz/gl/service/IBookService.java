package cn.sz.gl.service;

import java.util.List;

import cn.sz.gl.pojo.Book;

public interface IBookService {

	public List<Book> findall();
	
	public Book findBookById(Integer bookid);
}
