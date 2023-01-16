package com.assignment.AccountManagement.exceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.assignment.AccountManagement.exception.AccountNotFoundException;
import com.assignment.AccountManagement.exception.CustomerIsNotValid;

@ControllerAdvice
public class ExceptionalHandler extends ResponseEntityExceptionHandler {

	/*
	 * Exceptional Handler for AccountNotFoundException
	 */
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<Object> accountNotFoundException(AccountNotFoundException ex, WebRequest request){
		
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
		
	}
	
	
	/*
	 * Exceptional Handler for CustomerIsNotValid
	 */
	
	@ExceptionHandler(CustomerIsNotValid.class)
	public ResponseEntity<Object> customerIsNotValid(CustomerIsNotValid ex, WebRequest request){
		
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
		
	}
}

