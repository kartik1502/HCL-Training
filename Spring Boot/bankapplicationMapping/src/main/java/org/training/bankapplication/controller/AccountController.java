package org.training.bankapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.training.bankapplication.dto.DepositDto;
import org.training.bankapplication.dto.Response;
import org.training.bankapplication.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PatchMapping("/deposit")
	public Response depositAmount(@RequestBody DepositDto depositDto) {
		Response response = new Response();
		if(depositDto.getAmount() < 0) {
			response.setMessage("Amount Should be atleast Rs.500");
			return response;
		}
		return accountService.deposit(depositDto);
	}
}
