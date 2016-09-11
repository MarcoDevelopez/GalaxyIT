package com.galaxybis.galaxyit.ejb.dao.exception;

public class EJBDAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public EJBDAOException() {
		super();
	}

	public EJBDAOException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EJBDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public EJBDAOException(String message) {
		super(message);
	}

	public EJBDAOException(Throwable cause) {
		super(cause);
	}

}
