package com.assignment.AccountManagement.exception;

public class AccountNotFoundException extends RuntimeException {

	private String message;
	private static final long serialVersionUID = -8966396862859209474L;
	
	public AccountNotFoundException() {
		
	}

	public AccountNotFoundException(String errMssg) {
		super(errMssg);
		this.message = errMssg;
	}
}
