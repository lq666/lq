package cn.sz.gl.pojo;

import java.io.Serializable;

public class StoreHouse implements Serializable {

	private Book book;
	private Integer bookCount;
	public Integer getBookCount() {
		return bookCount;
	}
	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
