package org.training.bankapplication.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.bankapplication.dto.DepositDto;
import org.training.bankapplication.entity.Account;
import org.training.bankapplication.repository.AccountRepository;
import org.training.bankapplication.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public String addAccount(int initialDeposit, String accountType, long customerId) {

		Account account = new Account();

		long accountNumber = (long) (Math.floor(Math.random() * 9000000000000l) + 1000000000000l);
		while (accountRepository.findAccountByAccountNumber(accountNumber) != null) {
			accountNumber = (long) (Math.floor(Math.random() * 9000000000000l) + 1000000000000l);
		}

		account.setAccountType(accountType);
		account.setBalance(initialDeposit);
		account.setAccountNumber(accountNumber);
		account.setCustomerId(customerId);

		accountRepository.save(account);

		return "Account Created Successfully";

	}

	@Override
	public String deposit(DepositDto depositDto) {

		Account account = accountRepository.findAccountByAccountNumber(depositDto.getAccountNumber());

		if (account == null) {
			return "Invalid Account Number";
		}

		account.setBalance(account.getBalance() + depositDto.getAmount());
		accountRepository.save(account);

		return "Amount Deposited Successfully";
	}

}
