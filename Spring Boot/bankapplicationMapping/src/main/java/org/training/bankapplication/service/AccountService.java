package org.training.bankapplication.service;

import org.training.bankapplication.dto.DepositDto;
import org.training.bankapplication.dto.Response;
import org.training.bankapplication.entity.Customer;

public interface AccountService {

	Response addAccount(int initialDeposit, String accountType, Customer customer);

	Response deposit(DepositDto depositDto);

}
