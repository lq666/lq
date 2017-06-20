package cn.sz.gl.dao.impl;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import cn.sz.gl.dao.IUserDAO;
import cn.sz.gl.pojo.Users;
@Repository
public class UserDAOImpl extends SqlSessionDaoSupport implements IUserDAO {

	@Override
	public Users islogin(Users user) {
		return super.getSqlSession().selectOne("cn.sz.gl.pojo.Users.islogin", user);
	}

}
