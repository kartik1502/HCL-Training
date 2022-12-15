package org.training.schoolmanagement.exception;

import java.util.List;

import lombok.Data;


public class ErrorResponse {
	Long errorCode;
	List<String> errors;

	public ErrorResponse(Long errorCode, List<String> errors) {
		super();
		this.errorCode = errorCode;
		this.errors = errors;
	}

	public Long getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Long errorCode) {
		this.errorCode = errorCode;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	
}