package com.assignment.AccountManagement.entities;

import java.util.List;


public class Customer {
	
	private Long customerId;
	private String name;
	private String email;
	private List<Account> account;
	
	public Customer(Long customerId, String name, String email) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
	}
	
	public Customer(Long customerId, String name, String email, List<Account> account) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.account = account;
	}

	public Customer() {
		
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}
}