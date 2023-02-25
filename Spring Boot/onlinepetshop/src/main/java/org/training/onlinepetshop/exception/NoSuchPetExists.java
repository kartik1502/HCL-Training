package org.training.onlinepetshop.exception;

public class NoSuchPetExists extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public NoSuchPetExists(String message) {
		super();
		this.message = message;
	}

	public NoSuchPetExists() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
