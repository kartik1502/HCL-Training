package org.training.onlinepetshop.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public UserNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public UserNotFoundException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
