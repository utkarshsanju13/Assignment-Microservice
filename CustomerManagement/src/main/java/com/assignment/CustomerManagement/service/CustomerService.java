package com.assignment.CustomerManagement.service;

import java.util.List;

import com.assignment.CustomerManagement.entities.Customer;


public interface CustomerService {
	
	public List<Customer> getAllCustomer();
	
	public Customer getCustomer(Long customerId);

	public Customer save(Customer newCustomer);
	
	public Customer update(Long id, Customer updatedCustomer);

	public Customer deleteCustomer(Long customerId);
}
