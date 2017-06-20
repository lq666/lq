package cn.sz.gl.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.sz.gl.dao.IStoreHouseDAO;
import cn.sz.gl.pojo.StoreHouse;
@Repository
public class StoreHouseDAOImpl extends SqlSessionDaoSupport implements
		IStoreHouseDAO {

	@Override
	public int findBookCountByBookid(Integer bookid) {
		return super.getSqlSession().selectOne("cn.sz.gl.pojo.StoreHouse.findBookCountByBookid", bookid);
	}

	@Override
	public StoreHouse findStoreHouseByBookid(Integer bookid) {
		return super.getSqlSession().selectOne("cn.sz.gl.pojo.StoreHouse.findStoreHouseByBookid", bookid);
	}

	@Override
	public boolean changeBookCount(Integer bookid) {
		int res = super.getSqlSession().update("cn.sz.gl.pojo.StoreHouse.changeCount", bookid);
		return res>0?true:false;
	}

}
