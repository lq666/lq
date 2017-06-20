package cn.sz.gl.dao;

import cn.sz.gl.pojo.StoreHouse;

public interface IStoreHouseDAO {

	public int findBookCountByBookid(Integer bookid);
	
	public StoreHouse findStoreHouseByBookid(Integer bookid);
	
	/**
	 * �ֿ������������һ
	 * @param bookid
	 * @return
	 */
	public boolean changeBookCount(Integer bookid);
}
