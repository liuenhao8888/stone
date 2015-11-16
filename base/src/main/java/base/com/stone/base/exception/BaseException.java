package com.stone.base.exception;

/**
 * 基类异常定义
 * 
 * @author stone
 *
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = -2528721270540362905L;

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

}
