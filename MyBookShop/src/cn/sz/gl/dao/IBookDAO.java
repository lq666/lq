package cn.sz.gl.dao;

import java.util.List;

import cn.sz.gl.pojo.Book;

public interface IBookDAO {

	public List<Book> findall();
	
	public Book findBookById(Integer bookid);
	
	/**
	 * 根据书的编号，查询书的价格
	 * @param bookid
	 * @return
	 */
	public Integer findPriceByBookid(Integer bookid);
}
