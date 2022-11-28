package org.training.bankapplication.service;

import org.training.bankapplication.dto.DepositDto;
import org.training.bankapplication.dto.Response;

public interface AccountService {

	Response addAccount(int initialDeposit, String accountType, long customerId);

	Response deposit(DepositDto depositDto);

}
