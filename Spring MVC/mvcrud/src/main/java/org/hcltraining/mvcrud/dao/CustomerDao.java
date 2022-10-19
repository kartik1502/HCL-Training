package org.hcltraining.mvcrud.dao;

import org.hcltraining.mvcrud.dto.Customer;
import org.springframework.stereotype.Component;

@Component
public interface CustomerDao {
	
	public Customer saveCustomer(Customer customer);

}
