package cn.sz.gl.service.impl;

import org.springframework.stereotype.Service;

import cn.sz.gl.dao.IUserDAO;
import cn.sz.gl.pojo.Users;
import cn.sz.gl.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {

	private IUserDAO userDAOImpl;
	
	@Override
	public Users islogin(Users user) {
		if(user==null||user.getLoginname()==null||user.getLoginname().equals("")||user.getLoginpwd()==null||user.getLoginpwd().equals("")){
			return null;
		}
		return userDAOImpl.islogin(user);
	}

	public IUserDAO getUserDAOImpl() {
		return userDAOImpl;
	}

	public void setUserDAOImpl(IUserDAO userDAOImpl) {
		this.userDAOImpl = userDAOImpl;
	}

}
