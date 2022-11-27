package org.hcltraining.bankapplication.service.implementation;

import java.util.regex.Pattern;

import org.hcltraining.bankapplication.entity.Account;
import org.hcltraining.bankapplication.entity.Customer;
import org.hcltraining.bankapplication.entity.Transcation;
import org.hcltraining.bankapplication.repository.AccountRepository;
import org.hcltraining.bankapplication.repository.CustomerRepository;
import org.hcltraining.bankapplication.repository.TranscationRepository;
import org.hcltraining.bankapplication.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImplementation implements BankService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	TranscationRepository transcationRepository;

	@Autowired
	Account account;

	@Autowired
	Transcation transcation;

	@Override
	public String addCustomer(Customer customer, int initialDeposit, String accountType) {

		if (!Pattern.matches("[a-zA-Z]+", customer.getFirstName()))
			return "First Name is Mandatory";

		if (customer.getAge() < 18 || customer.getAge() > 120)
			return "Age is Invalid";

		if (!Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]", customer.getPanNumber()))
			return "Pan Number is invalid";

		if (!Pattern.matches("^[a-zA-Z0-9-_+!#$%&*{|}.]+@[a-zA-Z0-9.-]+$", customer.getEmailId()))
			return "Email is invalid";

		if (!Pattern.matches("[6-7][0-9]{9}", customer.getContactNumber()))
			return "Contact Number is invalid";

		if (initialDeposit < 1000)
			return "Initial Deposit should be minimum Rs.1,000";

		customerRepository.save(customer);
		account.setBalance(initialDeposit);
		account.setAccountType(accountType);

		long accountNumber = (long) (Math.floor(Math.random() * 9000000000000l) + 1000000000000l);
		while (accountRepository.findAccountByAccountNumber(accountNumber) != null) {
			accountNumber = (long) (Math.floor(Math.random() * 9000000000000l) + 1000000000000l);
		}

		account.setAccountNumber(accountNumber);
		account.setCustomerId(customer.getCustomerId());

		accountRepository.save(account);

		return "Customer Details added and Account created";
	}

	@Override
	public String fundTransfer(long fromAccoountNumber, long toAccountNumber, int amount) {

		Account fromAccount = accountRepository.findAccountByAccountNumber(fromAccoountNumber);
		if (fromAccount == null)
			return "Invalid From Account";

		Account toAccount = accountRepository.findAccountByAccountNumber(toAccountNumber);
		if (toAccount == null)
			return "To Account is Invalid";

		if (amount <= 0 || amount >= fromAccount.getBalance())
			return "Insufficient Funds" + fromAccount.getBalance();

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);

		transcation.setFromAccountNumber(fromAccoountNumber);
		transcation.setToAccountNumber(toAccountNumber);
		transcation.setAmount(amount);

		transcationRepository.save(transcation);

		return "Fund transfer was successfull";
	}

}
