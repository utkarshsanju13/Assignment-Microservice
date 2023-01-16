package com.assignment.AccountManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.assignment.AccountManagement.entities.Account;
import com.assignment.AccountManagement.entities.Customer;
import com.assignment.AccountManagement.exception.AccountNotFoundException;
import com.assignment.AccountManagement.exception.CustomerIsNotValid;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	ArrayList<Account> list = new ArrayList<>();
	
	public AccountServiceImpl() {
		
		list.add(new Account(2232L, 150L, 2L));
		list.add(new Account(2231L, 250L, 3L));
		list.add(new Account(2230L, 350L, 2L));
	}
	
	@Override
	public List<Account> deleteAccount(Long customerId) {
		

		List<Account> listOfAccountToBeDeleted = list.stream().
				filter(account -> account.getCustomerId().equals(customerId)).
					collect(Collectors.toList());
		if(listOfAccountToBeDeleted.isEmpty())
			throw new AccountNotFoundException("Account doesn't found of given customer Id :"+ customerId);
		
		list.removeAll(listOfAccountToBeDeleted);
		return listOfAccountToBeDeleted;
		
	}

	//THIS HAS TO DELETED ONLY FOR TESTING PURPOSE
	@Override
	public List<Account> getAllAccount() {
		return list;
	}
	
	@Override
	public Customer getAllDetails(Long customerId) {
		
		
		List<Account> accountDetails = list.stream().
				filter(account -> account.getCustomerId().equals(customerId)).
					collect(Collectors.toList());
		
		if(accountDetails.isEmpty())
			throw new AccountNotFoundException("Account doesn't found of given customer Id :"+ customerId);
		
		
		Customer customerDetails = this.restTemplate.getForObject("http://localhost:8080/customer/"+ customerId, Customer.class);
		customerDetails.setAccount(accountDetails);
		
		return customerDetails;
	}

	@Override
	public Account addMoney(Long accountId, Customer customer, Long amount) {
		
		Account accountDetails = list.stream().filter(account -> 
				account.getAccountId().equals(accountId)).findAny().
					orElseThrow(() -> new AccountNotFoundException("The Account number is not correct:"+ accountId));
		
				/* Validation of Customer Details */
		try {
			this.restTemplate.getForObject("http://localhost:8080/customer/"+ customer.getCustomerId(), Customer.class);
			accountDetails.setBalance(accountDetails.getBalance()+amount);
		}catch(HttpStatusCodeException e) {
			throw new CustomerIsNotValid("The Customer Details is Invalid");
		}
		
		
		return accountDetails;
		
	}
	
	@Override
	public Account withdrawMoney(Long accountId, Customer customer, Long amount) {
		
		Account accountDetails = list.stream().filter(account -> 
				account.getAccountId().equals(accountId)).findAny().
					orElseThrow(() -> new AccountNotFoundException("The Account number is not correct:"+ accountId));
		
				/* Validation of Customer Details */
		try {
			this.restTemplate.getForObject("http://localhost:8080/customer/"+ customer.getCustomerId(), Customer.class);
			accountDetails.setBalance(accountDetails.getBalance()-amount);
		}catch(HttpStatusCodeException e) {
			throw new CustomerIsNotValid("The Customer Details is Invalid");
		}
		
		return accountDetails;
		
	}


}
