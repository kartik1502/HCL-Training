package org.training.onlinepetshop.exception;

public class AccessDenied extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String message;

	public AccessDenied(String message) {
		super();
		this.message = message;
	}

	public AccessDenied() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
