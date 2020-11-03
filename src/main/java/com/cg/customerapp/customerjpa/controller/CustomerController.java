package com.cg.customerapp.customerjpa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customerapp.customerjpa.dto.CreateCustomer;
import com.cg.customerapp.customerjpa.dto.DetailCustomer;
import com.cg.customerapp.customerjpa.dto.UpdateCustomer;
import com.cg.customerapp.customerjpa.entities.Customer;
import com.cg.customerapp.customerjpa.service.ICustomerService;
import com.cg.customerapp.customerjpa.util.CustomerUtil;

@Validated
@RequestMapping("/customer")
@RestController
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@Autowired
	private CustomerUtil customerUtil;
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public DetailCustomer add(@RequestBody  @Valid CreateCustomer requestData)
	{
		Customer customer = service.register(new Customer(requestData.getFirstName(), requestData.getLastName()));
		return customerUtil.getDetails(customer);
	}
	
	@PutMapping("/update")
	public DetailCustomer update(@RequestBody UpdateCustomer requestData)
	{
		Customer customer = new Customer(requestData.getFirstName(), requestData.getLastName());
		customer.setId(requestData.getId());
		customer = service.update(customer);
		return customerUtil.getDetails(customer);
	}
	
	@GetMapping("/get/id/{id}")
	public DetailCustomer fetchCustomer(@PathVariable("id") Long id)
	{
		Customer customer = service.findById(id);
		return customerUtil.getDetails(customer);
	}
	
	@DeleteMapping("/remove/id/{id}")
	public String removeCustomer(@PathVariable("id") Long id)
	{
		service.deleteById(id);
        return ("removed customer with id=" + id);

	}
	
	

}
