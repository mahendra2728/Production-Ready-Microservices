package com.pm.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.customer.service.CustomerService;
import com.pm.rentapp.commons.model.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customserService;
	
	
	@PostMapping("/customer")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> save(@RequestBody Customer customer) {
		Customer cust = customserService.save(customer);
		if (cust == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(cust, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/customer")
	@PreAuthorize("hasAuthority('USER')")
	public ResponseEntity<?> getCustomers(){
		return new ResponseEntity<>(customserService.findAll(),HttpStatus.OK);
	}
}
