package com.cg.customerapp.customerjpa.service;

import com.cg.customerapp.customerjpa.entities.Customer;

public interface ICustomerService {

    Customer register(Customer customer);
	
    Customer findById(Long id);
	
	void deleteById(Long id);

	Customer update(Customer customer);

}
