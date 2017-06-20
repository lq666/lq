package cn.sz.gl.service;

import cn.sz.gl.pojo.StoreHouse;

public interface IStoreHouseService {

	public int findBookCountByBookid(Integer bookid);
	
	public StoreHouse findStoreHouseByBookid(Integer bookid);
	
	public boolean buyOneBook(Integer bookid,Integer accid);
}
