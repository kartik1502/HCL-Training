package org.training.employeemanagement.exception;

public class NoSuchEmployeeExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public NoSuchEmployeeExists(String message) {
		super(message);
		this.message = message;
	}

	public NoSuchEmployeeExists() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
