package cn.sz.gl.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sz.gl.dao.IAccountDAO;
import cn.sz.gl.dao.IBookDAO;
import cn.sz.gl.dao.IStoreHouseDAO;
import cn.sz.gl.pojo.StoreHouse;
import cn.sz.gl.service.IStoreHouseService;
import cn.sz.gl.util.BalanceLessException;
import cn.sz.gl.util.BookCountLessException;
@Service
public class StoreHouseServiceImpl implements IStoreHouseService {

	private IStoreHouseDAO storeHouseDAOImpl;
	private IAccountDAO accountDAOImpl;
	private IBookDAO bookDAOImpl;
	@Override
	public int findBookCountByBookid(Integer bookid) {
		if(bookid==null||bookid==0){
			return 0;
		}
		return storeHouseDAOImpl.findBookCountByBookid(bookid);
	}
	
	@Override
	public StoreHouse findStoreHouseByBookid(Integer bookid) {
		if(bookid==null||bookid==0){
			return null;
		}
		return storeHouseDAOImpl.findStoreHouseByBookid(bookid);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName={"cn.sz.gl.util.BalanceLessException","cn.sz.gl.util.BookCountLessException"})
	public boolean buyOneBook(Integer bookid, Integer accid) {
		
		//1.减余额
		//这里需要先查询出账户原来的余额，再查出书的价格，两者相减，差作为下面的参数
		int balance = accountDAOImpl.findBalanceByAccid(accid);//得到原来的余额
		int price = bookDAOImpl.findPriceByBookid(bookid);//查书的价格
		if(balance<price){
			throw new BalanceLessException("余额不足");
		}
		boolean moneyFlag = accountDAOImpl.changeBalance(accid, balance-price);
		
		//2.减数量
		//从仓库查书的数量
		int bookCount = storeHouseDAOImpl.findBookCountByBookid(bookid);
		//仓库中书的数量减一
		if(bookCount<=0){
			throw new BookCountLessException("数量不足");
		}
		boolean countFlag = storeHouseDAOImpl.changeBookCount(bookid);
		
		
		
		return true;
	}
	
	
	
	
	
	public IStoreHouseDAO getStoreHouseDAOImpl() {
		return storeHouseDAOImpl;
	}
	public void setStoreHouseDAOImpl(IStoreHouseDAO storeHouseDAOImpl) {
		this.storeHouseDAOImpl = storeHouseDAOImpl;
	}

	public IAccountDAO getAccountDAOImpl() {
		return accountDAOImpl;
	}

	public void setAccountDAOImpl(IAccountDAO accountDAOImpl) {
		this.accountDAOImpl = accountDAOImpl;
	}

	public IBookDAO getBookDAOImpl() {
		return bookDAOImpl;
	}

	public void setBookDAOImpl(IBookDAO bookDAOImpl) {
		this.bookDAOImpl = bookDAOImpl;
	}




}
