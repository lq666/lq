package cn.sz.gl.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sz.gl.dao.IAccountDAO;
import cn.sz.gl.pojo.Account;
import cn.sz.gl.service.IAccountService;
@Service
public class AccountServiceImpl implements IAccountService {

	private IAccountDAO accountDAOImpl;
	@Override
	public List<Account> findMyAccInfo(Integer userid) {
		if(userid==null||userid==0){
			return null;
		}
		return accountDAOImpl.findMyAccInfo(userid);
	}
	public IAccountDAO getAccountDAOImpl() {
		return accountDAOImpl;
	}
	public void setAccountDAOImpl(IAccountDAO accountDAOImpl) {
		this.accountDAOImpl = accountDAOImpl;
	}

}
