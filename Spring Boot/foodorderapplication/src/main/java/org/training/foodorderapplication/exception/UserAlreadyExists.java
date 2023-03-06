package org.training.foodorderapplication.exception;

import lombok.Data;

public class UserAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String message;

	public UserAlreadyExists(String message) {
		super();
		this.message = message;
	}

	public UserAlreadyExists() {
		super();
		this.message = "";
	}

	public String getMessage() {
		return message;
	}

}
