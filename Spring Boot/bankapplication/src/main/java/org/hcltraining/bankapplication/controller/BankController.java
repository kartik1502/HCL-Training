package org.hcltraining.bankapplication.controller;

import org.hcltraining.bankapplication.entity.Customer;
import org.hcltraining.bankapplication.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	BankService bankService;
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer,@RequestParam int initialDeposit, @RequestParam String accountType) {
		return bankService.addCustomer(customer,initialDeposit,accountType);
	}
	
	@PostMapping("/fundTransfer")
	public String fundTransfer(@RequestParam long fromAccoountNumber,@RequestParam long toAccountNumber,@RequestParam int amount) {
		return bankService.fundTransfer(fromAccoountNumber,toAccountNumber,amount);
	}

}
