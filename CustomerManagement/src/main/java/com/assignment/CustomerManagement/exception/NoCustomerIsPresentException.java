package com.assignment.CustomerManagement.exception;

public class NoCustomerIsPresentException extends RuntimeException {

	private static final long serialVersionUID = -9115881402556793991L;
	private String message;

	public NoCustomerIsPresentException() {

	}

	public NoCustomerIsPresentException(String mssg) {
		super(mssg);
		this.message = mssg;

	}
}
