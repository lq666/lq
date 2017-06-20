package cn.sz.gl.util;

public class BalanceLessException extends RuntimeException {

	public BalanceLessException(){
		super();
	}
	
	public BalanceLessException(String msg){
		super(msg);
	}
}
