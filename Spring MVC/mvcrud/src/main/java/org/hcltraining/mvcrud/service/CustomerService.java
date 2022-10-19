package org.hcltraining.mvcrud.service;

import org.hcltraining.mvcrud.dto.Customer;
import org.springframework.stereotype.Component;

@Component
public interface CustomerService {
	
	public Customer saveCustomer(Customer customer);

}
