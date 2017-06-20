package cn.sz.gl.util;

public class BookCountLessException extends RuntimeException {

	public BookCountLessException(){
		super();
	}
	
	public BookCountLessException(String msg){
		super(msg);
	}
}
