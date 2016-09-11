package com.galaxybis.galaxyit.ejb.service.exception;

public class EJBServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public EJBServiceException() {
		super();
	}

	public EJBServiceException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public EJBServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EJBServiceException(String arg0) {
		super(arg0);
	}

	public EJBServiceException(Throwable arg0) {
		super(arg0);
	}

	
}
