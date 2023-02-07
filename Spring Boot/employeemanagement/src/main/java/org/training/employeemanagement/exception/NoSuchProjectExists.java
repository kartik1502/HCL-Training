package org.training.employeemanagement.exception;

public class NoSuchProjectExists extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public NoSuchProjectExists(String message) {
		super();
		this.message = message;
	}

	public NoSuchProjectExists() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
