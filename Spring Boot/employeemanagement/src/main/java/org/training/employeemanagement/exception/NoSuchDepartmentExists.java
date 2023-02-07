package org.training.employeemanagement.exception;

public class NoSuchDepartmentExists extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public NoSuchDepartmentExists(String message) {
		super(message);
		this.message = message;
	}

	public NoSuchDepartmentExists() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	 
	

}
