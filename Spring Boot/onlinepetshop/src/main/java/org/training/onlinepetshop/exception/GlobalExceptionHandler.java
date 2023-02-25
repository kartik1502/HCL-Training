package org.training.onlinepetshop.exception;

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

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest req) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getLocalizedMessage());
		ErrorResponse response = new ErrorResponse(5006l, errors);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PasswordDoseNotMatch.class)
	public ResponseEntity<Object> handlePasswordDoseNotMatchException(PasswordDoseNotMatch ex, WebRequest req) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getLocalizedMessage());
		ErrorResponse response = new ErrorResponse(5007l, errors);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserAlreadyExists.class)
	public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExists ex, WebRequest req) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getLocalizedMessage());
		ErrorResponse response = new ErrorResponse(5008l, errors);
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(AccessDenied.class)
	public ResponseEntity<Object> handleAccessDeniedException(AccessDenied ex, WebRequest req) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getLocalizedMessage());
		ErrorResponse response = new ErrorResponse(5009l, errors);
		return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
	}
}
