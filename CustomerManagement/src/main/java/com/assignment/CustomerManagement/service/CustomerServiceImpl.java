package com.assignment.CustomerManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assignment.CustomerManagement.entities.Account;
import com.assignment.CustomerManagement.entities.Customer;
import com.assignment.CustomerManagement.exception.NoCustomerIsPresentException;
import com.assignment.CustomerManagement.exception.NoSuchCustomerExistsException;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private RestTemplate restTemplate;

	ArrayList<Customer> list = new ArrayList<Customer>();

	public CustomerServiceImpl() {
		list.add(new Customer(1L, "Utkarsh Gupta", "utkarsh10@gmail.com"));
		list.add(new Customer(2L, "Apporva", "apporva1@gmail.com"));
		list.add(new Customer(3L, "Ritika", "ritika2@gmail.com"));
	}

	@Override
	public List<Customer> getAllCustomer() {

		if(list.isEmpty())
			throw new NoCustomerIsPresentException("No Cutomer is register yet");
		
			return list;
	}

	@Override
	public Customer getCustomer(Long customerId){
		Customer cust = list.stream().filter(customer -> customer.getCustomerId().equals(customerId)).findAny()
				.orElseThrow(() -> new NoSuchCustomerExistsException("Customer not found for this id :: " + customerId));
		
		return cust;
	}

	@Override
	public Customer save(Customer newCustomer) {
		
		list.add(newCustomer);
		
		return newCustomer;
	}
	
	@Override
	public Customer update(Long customerId, Customer updatedCustomer) {
		
		Customer exitingCustomer = list.stream().filter(customer -> customer.getCustomerId().equals(customerId))
				.findAny()
				.orElseThrow(() -> new NoSuchCustomerExistsException("Customer not found for this id :: " + customerId));
		
		exitingCustomer.setEmail(updatedCustomer.getEmail());
		exitingCustomer.setName(updatedCustomer.getName());
		
		CustomerServiceImpl custImpl = new CustomerServiceImpl();
		
		final Customer updatedCust = custImpl.save(exitingCustomer);
		return updatedCust;
	}
	
	@Override
	public Customer deleteCustomer(Long customerId) {
		
		Customer exitingCustomer = list.stream().filter(customer -> customer.getCustomerId().equals(customerId))
				.findAny()	
				.orElseThrow(() -> new NoSuchCustomerExistsException("Customer not found for this id :: " + customerId));

		HttpEntity<Long> requestEntity = new HttpEntity<Long>(customerId);
		ResponseEntity<?> accountToBeDeleted = this.restTemplate.exchange("http://accountmanagement-service/account/deleteAccount/"+ customerId, HttpMethod.DELETE, requestEntity, List.class);
		
		List<Account> listOfDeletedAccount = (List<Account>) accountToBeDeleted.getBody();
		exitingCustomer.setAccount(listOfDeletedAccount);
		list.remove(exitingCustomer);
		
		return exitingCustomer;
	}

}
