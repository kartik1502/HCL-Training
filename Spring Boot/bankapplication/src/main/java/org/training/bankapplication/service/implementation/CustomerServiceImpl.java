package org.training.bankapplication.service.implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.bankapplication.dto.Response;
import org.training.bankapplication.entity.Customer;
import org.training.bankapplication.repository.CustomerRepository;
import org.training.bankapplication.service.AccountService;
import org.training.bankapplication.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountService accountService;

	@Override
	public Response addCustomer(Customer customer, int initialDeposit, String accountType) {
		
		Response response = new Response();
		List<Customer> customers = customerRepository.findCustomerByPanNumber(customer.getPanNumber());
		if(customers.size() > 0) {
			response.setMessage("Account with same Pan details already present");
			return response;
		}
		customerRepository.save(customer);
		Response accountResponse = accountService.addAccount(initialDeposit, accountType, customer.getCustomerId());
		response.setMessage("Customer Details added and "+accountResponse.getMessage());
		return response;
	}

}
