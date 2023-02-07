package org.training.employeemanagement.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorDetails = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			errorDetails.add(error.getDefaultMessage());
		}
		ErrorResponse response = new ErrorResponse(4008l, errorDetails);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DepartmentAlreadyExistsException.class)
	public ResponseEntity<Object> handleDepartmentAlreadyExistsException(DepartmentAlreadyExistsException ex,
			WebRequest req) {
		List<String> errorResponses = new ArrayList<>();
		errorResponses.add(ex.getLocalizedMessage());
		ErrorResponse response = new ErrorResponse(5000l, errorResponses);
		return new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
	}

	@ExceptionHandler(NoSuchEmployeeExists.class)
	public ResponseEntity<Object> handleNoSuchEmployeeExists(NoSuchEmployeeExists ex, WebRequest req) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getLocalizedMessage());
		ErrorResponse response = new ErrorResponse(5008l, errors);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmployeeAlreadyExists.class)
	public ResponseEntity<Object> handleEmployeeAlreadyExists(EmployeeAlreadyExists ex, WebRequest req) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getLocalizedMessage());
		ErrorResponse response = new ErrorResponse(5002l, errors);
		return new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(NoSuchDepartmentExists.class)
	public ResponseEntity<Object> handleNoSuchDepartmentExists(NoSuchDepartmentExists ex, WebRequest req){
		List<String> errors = new ArrayList<>();
		errors.add(ex.getLocalizedMessage());
		ErrorResponse response = new ErrorResponse(5006l, errors);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchProjectExists.class)
	public ResponseEntity<Object> handleNoSuchProjectExistsException(NoSuchProjectExists ex, WebRequest req){
		List<String> errors = new ArrayList<>();
		errors.add(ex.getLocalizedMessage());
		ErrorResponse response = new ErrorResponse(5004l, errors);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
