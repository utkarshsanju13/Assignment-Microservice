package com.assignment.CustomerManagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.CustomerManagement.entities.Customer;
import com.assignment.CustomerManagement.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer() {

		List<Customer> listOfCustomer = customerService.getAllCustomer();

		return new ResponseEntity<List<Customer>>(listOfCustomer, HttpStatus.OK);
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCutomer(@PathVariable("customerId") Long customerId) {

		
			Customer customer = customerService.getCustomer(customerId);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}

	@PostMapping(path = "/addCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> create(@RequestBody Customer newCustomer) {

		Customer customer = customerService.save(newCustomer);

		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateCustomer/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") Long customerId,
	  @RequestBody Customer customerDetails)  {
		
			customerService.update(customerId, customerDetails);
		
		return new ResponseEntity<Customer>(customerDetails, HttpStatus.CREATED);
	   
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") Long customerId) {
		
		
		Customer deletedCustomer = customerService.deleteCustomer(customerId);
		
		return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);
		
		
	}

}

