package com.haurylenka.projects.rest.exceptions;

public class FormatterException extends Exception {

	private static final long serialVersionUID = 1L;

	public FormatterException() {
		super();
	}

	public FormatterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FormatterException(String message, Throwable cause) {
		super(message, cause);
	}

	public FormatterException(String message) {
		super(message);
	}

	public FormatterException(Throwable cause) {
		super(cause);
	}
	
}
