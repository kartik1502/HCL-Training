package org.hcltraining.bankapplication.service;

import org.hcltraining.bankapplication.entity.Customer;

public interface BankService {


	String addCustomer(Customer customer, int initialDeposit, String accountType);

	

	String fundTransfer(long fromAccoountNumber, long toAccountNumber, int amount);

}
