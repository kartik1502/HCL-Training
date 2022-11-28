package org.training.bankapplication.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.bankapplication.dto.DepositDto;
import org.training.bankapplication.dto.Response;
import org.training.bankapplication.entity.Account;
import org.training.bankapplication.entity.Customer;
import org.training.bankapplication.repository.AccountRepository;
import org.training.bankapplication.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Response addAccount(int initialDeposit, String accountType, Customer customer) {

		Account account = new Account();

		long accountNumber = (long) (Math.floor(Math.random() * 9000000000000l) + 1000000000000l);
		while (accountRepository.findAccountByAccountNumber(accountNumber) != null) {
			accountNumber = (long) (Math.floor(Math.random() * 9000000000000l) + 1000000000000l);
		}

		account.setAccountType(accountType);
		account.setBalance(initialDeposit);
		account.setAccountNumber(accountNumber);
		account.setCustomer(customer);

		accountRepository.save(account);
		
		Response response = new Response();
		response.setMessage("Account Created Successfully");

		return response;

	}

	@Override
	public Response deposit(DepositDto depositDto) {

		Account account = accountRepository.findAccountByAccountNumber(depositDto.getAccountNumber());

		Response response = new Response();
		if (account == null) {
			response.setMessage("Invalid Account Number");
			return response;
		}

		account.setBalance(account.getBalance() + depositDto.getAmount());
		accountRepository.save(account);
		
		
		response.setMessage("Amount Deposited Successfully");

		return response;
	}

}
