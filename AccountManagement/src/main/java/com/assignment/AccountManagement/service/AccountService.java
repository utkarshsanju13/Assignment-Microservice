package com.assignment.AccountManagement.service;

import java.util.List;

import com.assignment.AccountManagement.entities.Account;
import com.assignment.AccountManagement.entities.Customer;

public interface AccountService {
	
	public List<Account> deleteAccount(Long accountId);

	public List<Account> getAllAccount();

	public Customer getAllDetails(Long accountId);

	public Account addMoney(Long accountId, Customer customerDetails, Long amount);

	public Account withdrawMoney(Long accountId, Customer customerDetails, Long amount);
}
