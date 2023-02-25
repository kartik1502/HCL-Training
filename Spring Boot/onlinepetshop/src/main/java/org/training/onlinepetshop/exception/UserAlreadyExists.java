package org.training.onlinepetshop.exception;

public class UserAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public UserAlreadyExists(String message) {
		super(message);
		this.message = message;
	}

	public UserAlreadyExists() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
