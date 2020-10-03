package com.pm.customer.service;

import java.util.List;

import com.pm.rentapp.commons.model.Customer;

public interface CustomerService {

	Customer save(Customer customer);

	List<Customer> findAll();
}
