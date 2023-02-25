package org.training.onlinepetshop.exception;

public class PasswordDoseNotMatch extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;

	

	public PasswordDoseNotMatch() {
		super();
	}

	public PasswordDoseNotMatch(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
