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
		
		//1.�����
		//������Ҫ�Ȳ�ѯ���˻�ԭ�������ٲ����ļ۸��������������Ϊ����Ĳ���
		int balance = accountDAOImpl.findBalanceByAccid(accid);//�õ�ԭ�������
		int price = bookDAOImpl.findPriceByBookid(bookid);//����ļ۸�
		if(balance<price){
			throw new BalanceLessException("����");
		}
		boolean moneyFlag = accountDAOImpl.changeBalance(accid, balance-price);
		
		//2.������
		//�Ӳֿ���������
		int bookCount = storeHouseDAOImpl.findBookCountByBookid(bookid);
		//�ֿ������������һ
		if(bookCount<=0){
			throw new BookCountLessException("��������");
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
