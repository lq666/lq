package cn.sz.gl.dao;

import cn.sz.gl.pojo.StoreHouse;

public interface IStoreHouseDAO {

	public int findBookCountByBookid(Integer bookid);
	
	public StoreHouse findStoreHouseByBookid(Integer bookid);
	
	/**
	 * 仓库中书的数量减一
	 * @param bookid
	 * @return
	 */
	public boolean changeBookCount(Integer bookid);
}
