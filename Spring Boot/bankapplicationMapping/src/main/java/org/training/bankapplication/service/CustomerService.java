package org.training.bankapplication.service;

import org.training.bankapplication.dto.Response;
import org.training.bankapplication.entity.Customer;

public interface CustomerService {
	
	Response addCustomer(Customer customer, int initialDeposit, String accountType);

}
