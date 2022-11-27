package org.training.bankapplication.service;

import org.training.bankapplication.entity.Customer;

public interface CustomerService {
	
	String addCustomer(Customer customer, int initialDeposit, String accountType);

}
