package com.pm.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pm.rentapp.commons.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
