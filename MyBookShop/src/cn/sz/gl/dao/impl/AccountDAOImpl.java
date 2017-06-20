package cn.sz.gl.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.sz.gl.dao.IAccountDAO;
import cn.sz.gl.pojo.Account;
@Repository
public class AccountDAOImpl extends SqlSessionDaoSupport implements IAccountDAO {

	@Override
	public List<Account> findMyAccInfo(Integer userid) {
		return super.getSqlSession().selectList("cn.sz.gl.pojo.Account.findMyAccInfo", userid);
	}

	@Override
	public boolean changeBalance(Integer accid, Integer balance) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("balance", balance);
		map.put("accid", accid);
		int res = super.getSqlSession().update("cn.sz.gl.pojo.Account.changeBalance", map);
		return res>0?true:false;
	}

	@Override
	public Integer findBalanceByAccid(Integer accid) {
		return super.getSqlSession().selectOne("cn.sz.gl.pojo.Account.findBalanceByAccid", accid);
	}

}
