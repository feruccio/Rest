package com.haurylenka.projects.rest.exceptions;

public class RestImplLoadException extends Exception {

	private static final long serialVersionUID = 1L;

	public RestImplLoadException() {
		super();
		// nothing
	}

	public RestImplLoadException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RestImplLoadException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestImplLoadException(String message) {
		super(message);
	}

	public RestImplLoadException(Throwable cause) {
		super(cause);
	}

}
