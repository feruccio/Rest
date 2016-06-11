package com.haurylenka.projects.rest.exceptions;

public class RequestProcessException extends Exception {

	private static final long serialVersionUID = 1L;

	public RequestProcessException() {
		super();
	}

	public RequestProcessException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RequestProcessException(String message, Throwable cause) {
		super(message, cause);
	}

	public RequestProcessException(String message) {
		super(message);
	}

	public RequestProcessException(Throwable cause) {
		super(cause);
	}
	
}
