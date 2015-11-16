package com.stone.base.exception;

/**
 * 主键重复异常
 * 
 * @author stone
 *
 */
public class DuplicateKeyException extends DaoException {

	private static final long serialVersionUID = 989620752592415898L;

	public DuplicateKeyException(String message) {
		super(message);
	}

	public DuplicateKeyException(Throwable cause) {
		super(cause);
	}

	public DuplicateKeyException(String message, Throwable cause) {
		super(message, cause);
	}

}
