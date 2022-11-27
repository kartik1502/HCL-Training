package org.training.bankapplication.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public String addCustomer(Customer customer, int initialDeposit, String accountType) {
		
		customerRepository.save(customer);
		String accountResponse = accountService.addAccount(initialDeposit, accountType, customer.getCustomerId());
		return "Customer Details added and "+accountResponse;
	}

}
