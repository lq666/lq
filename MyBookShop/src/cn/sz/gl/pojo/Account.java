package cn.sz.gl.pojo;

import java.io.Serializable;

public class Account implements Serializable {

	private Integer accid;
	private Users users;
	private Integer balance;
	public Integer getAccid() {
		return accid;
	}
	public void setAccid(Integer accid) {
		this.accid = accid;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
}
