package org.training.bankapplication.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.training.bankapplication.entity.Customer;
import org.training.bankapplication.service.CustomerService;

@RestController
@RequestMapping("/bank")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/customers")
	public String addCustomer(@RequestBody Customer customer, @RequestParam int initialDeposit,
			@RequestParam String accountType) {
		
		if (!Pattern.matches("[a-zA-Z]+", customer.getFirstName()))
			return "First Name is Mandatory";

		if (customer.getAge() < 18 || customer.getAge() > 120)
			return "Age is Invalid";

		if (!Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]", customer.getPanNumber()))
			return "Pan Number is invalid";

		if (!Pattern.matches("^[a-zA-Z0-9-_+!#$%&*{|}.]+@[a-zA-Z0-9.-]+$", customer.getEmailId()))
			return "Email is invalid";

		if (!Pattern.matches("[6-9][0-9]{9}", customer.getContactNumber()))
			return "Contact Number is invalid";

		if (initialDeposit < 1000)
			return "Initial Deposit should be minimum Rs.1,000";
		
		return customerService.addCustomer(customer, initialDeposit, accountType);
	}
}
