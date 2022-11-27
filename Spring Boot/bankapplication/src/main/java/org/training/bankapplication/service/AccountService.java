package org.training.bankapplication.service;

import org.training.bankapplication.dto.DepositDto;

public interface AccountService {

	String addAccount(int initialDeposit, String accountType, long customerId);

	String deposit(DepositDto depositDto);

}
