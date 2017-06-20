package cn.sz.gl.pojo;

import java.io.Serializable;

public class Book implements Serializable {

	private Integer bookid;
	private String bookName;
	private String bookAuth;
	private String publicPress;
	private Integer price;
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuth() {
		return bookAuth;
	}
	public void setBookAuth(String bookAuth) {
		this.bookAuth = bookAuth;
	}
	public String getPublicPress() {
		return publicPress;
	}
	public void setPublicPress(String publicPress) {
		this.publicPress = publicPress;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}
