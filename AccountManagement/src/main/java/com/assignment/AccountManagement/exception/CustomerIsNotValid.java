package com.assignment.AccountManagement.exception;

public class CustomerIsNotValid extends RuntimeException {

	private String message;
	private static final long serialVersionUID = -4047833808426088276L;
	
	public CustomerIsNotValid() {
		
	}
	
	public CustomerIsNotValid(String errMssg) {
		super(errMssg);
		this.message = errMssg;
	}

}
