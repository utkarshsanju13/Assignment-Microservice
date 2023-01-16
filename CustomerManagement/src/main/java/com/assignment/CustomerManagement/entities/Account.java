package com.assignment.CustomerManagement.entities;

public class Account {

	private Long accountId;
	private Long balance;
	private Long customerId;
	
	public Account(Long accountId, Long balance, Long customerId) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.customerId = customerId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
