package cn.sz.gl.dao;

import java.util.List;

import cn.sz.gl.pojo.Account;

public interface IAccountDAO {

	public List<Account> findMyAccInfo(Integer userid);
	
	/**
	 * 查询指定账户的余额
	 * @param accid
	 * @return
	 */
	public Integer findBalanceByAccid(Integer accid);
	
	public boolean changeBalance(Integer accid,Integer balance);
}
