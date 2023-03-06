package org.training.foodorderapplication.exception;

public class PasswordDoseNotMatch extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final String message;

	public PasswordDoseNotMatch(String message) {
		super();
		this.message = message;
	}

	public PasswordDoseNotMatch() {
		super();
		this.message = "";
	}

	public String getMessage() {
		return message;
	}

}
