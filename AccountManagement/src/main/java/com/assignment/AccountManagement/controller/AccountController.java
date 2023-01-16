package com.assignment.AccountManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.AccountManagement.entities.Account;
import com.assignment.AccountManagement.entities.Customer;
import com.assignment.AccountManagement.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@DeleteMapping("/deleteAccount/{customerId}")
	public ResponseEntity<?> deleteAcount(@PathVariable("customerId") Long customerId){
		
		List<Account> deletedAccounts = accountService.deleteAccount(customerId);
		
		return new ResponseEntity<>(deletedAccounts, HttpStatus.OK);
	}
	
	//THIS HAS TO DELETED ONLY TO CHECK 
	@GetMapping("/getAllAccounts")
	public List<Account> getAllAccount(){
		
		return accountService.getAllAccount();
	}
	
	@GetMapping("/getAccountDetails/{customerId}")
	public ResponseEntity<Customer> getAccountDetails(@PathVariable("customerId") Long customerId) {
		
		Customer customerDetails = accountService.getAllDetails(customerId);
		return new ResponseEntity<>(customerDetails, HttpStatus.OK);	
	}
	
	@PutMapping("/addMoney/{accountId}")
	public ResponseEntity<Account> addMoney(@RequestParam("amount") Long amount,@PathVariable("accountId") Long accountId,
			@RequestBody Customer customerDetails){
		
			
				Account	updatedAccountDetails = accountService.addMoney(accountId, customerDetails, amount);
			
				return new ResponseEntity<>(updatedAccountDetails, HttpStatus.OK);
		
	}
	
	@PutMapping("/withdrawMoney/{accountId}")
	public ResponseEntity<Account> withdrawMoney(@RequestParam("amount") Long amount,@PathVariable("accountId") Long accountId,
			@RequestBody Customer customerDetails){
		
			
				Account updatedAccountDetails = accountService.withdrawMoney(accountId, customerDetails, amount);
			
				return new ResponseEntity<>(updatedAccountDetails, HttpStatus.OK);
		
	}

}
