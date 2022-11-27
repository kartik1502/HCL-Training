package org.training.bankapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.bankapplication.dto.DepositDto;
import org.training.bankapplication.service.AccountService;

@RestController
@RequestMapping("/bank")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PatchMapping("/deposit")
	public String depositAmount(@RequestBody DepositDto depositDto) {
		return accountService.deposit(depositDto);
	}
}
