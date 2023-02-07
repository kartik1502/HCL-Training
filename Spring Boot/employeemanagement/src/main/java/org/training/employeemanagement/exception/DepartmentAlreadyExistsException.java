package org.training.employeemanagement.exception;

public class DepartmentAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public DepartmentAlreadyExistsException() {
		super();
		this.message = "";
	}

	public DepartmentAlreadyExistsException(String message) {
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
