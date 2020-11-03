package com.cg.customerapp.customerjpa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.customerapp.customerjpa.dto.DetailCustomer;
import com.cg.customerapp.customerjpa.entities.Customer;

@Component
public class CustomerUtil {

	public List<DetailCustomer> getDetails(Collection<Customer> customers) {
		List<DetailCustomer> desired = new ArrayList<>();
		for (Customer customer : customers) {
			DetailCustomer details = getDetails(customer);
			desired.add(details);
		}
		return desired;
	}

	public DetailCustomer getDetails(Customer customer) {
		return new DetailCustomer(customer.getId(), customer.getFirstName(), customer.getLastName());
	}

}
