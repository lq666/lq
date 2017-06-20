package cn.sz.gl.dao;

import java.util.List;

import cn.sz.gl.pojo.Book;

public interface IBookDAO {

	public List<Book> findall();
	
	public Book findBookById(Integer bookid);
	
	/**
	 * ������ı�ţ���ѯ��ļ۸�
	 * @param bookid
	 * @return
	 */
	public Integer findPriceByBookid(Integer bookid);
}
