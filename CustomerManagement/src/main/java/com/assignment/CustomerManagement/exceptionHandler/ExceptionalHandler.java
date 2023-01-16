package com.assignment.CustomerManagement.exceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.assignment.CustomerManagement.exception.NoCustomerIsPresentException;
import com.assignment.CustomerManagement.exception.NoSuchCustomerExistsException;

@ControllerAdvice
public class ExceptionalHandler extends ResponseEntityExceptionHandler {

	/*
	 * Exceptional Handler for NoSuchCustomerExistsException
	 */
	
	@ExceptionHandler(NoSuchCustomerExistsException.class)
	public ResponseEntity<Object> noSuchCustomerExistsException(NoSuchCustomerExistsException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	/*
	 * Exceptional Handler for NoCustomerIsPresentException
	 */
	
	@ExceptionHandler(NoCustomerIsPresentException.class)
	public ResponseEntity<Object> noCustomerIsPresentException(NoCustomerIsPresentException ex, WebRequest request){
		
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
}
