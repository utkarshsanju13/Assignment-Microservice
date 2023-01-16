package com.assignment.CustomerManagement.exception;

public class NoSuchCustomerExistsException extends RuntimeException {

	private static final long serialVersionUID = 6438338279918500953L;
	private String message;

	public NoSuchCustomerExistsException() {
	}

	public NoSuchCustomerExistsException(String msg) {
		
		super(msg);
		this.message = msg;
	}
}
