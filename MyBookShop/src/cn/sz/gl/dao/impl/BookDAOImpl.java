package cn.sz.gl.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.sz.gl.dao.IBookDAO;
import cn.sz.gl.pojo.Book;
@Repository
public class BookDAOImpl extends SqlSessionDaoSupport implements IBookDAO {

	@Override
	public List<Book> findall() {
		return super.getSqlSession().selectList("cn.sz.gl.pojo.Book.findallbook");
	}

	@Override
	public Book findBookById(Integer bookid) {
		return super.getSqlSession().selectOne("cn.sz.gl.pojo.Book.findBookByBookid", bookid);
	}

	@Override
	public Integer findPriceByBookid(Integer bookid) {
		return super.getSqlSession().selectOne("cn.sz.gl.pojo.Book.findPriceByBookid", bookid);
	}

}
