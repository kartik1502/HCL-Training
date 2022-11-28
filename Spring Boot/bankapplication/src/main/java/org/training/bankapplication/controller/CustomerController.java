package org.training.bankapplication.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.training.bankapplication.dto.Response;
import org.training.bankapplication.entity.Customer;
import org.training.bankapplication.service.CustomerService;

@RestController

public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/customers")
	public Response addCustomer(@RequestBody Customer customer, @RequestParam int initialDeposit,
			@RequestParam String accountType) {

		Response response = new Response();

		if (!Pattern.matches("[a-zA-Z]+", customer.getFirstName())) {
			response.setMessage("First Name is Mandatory");
			return response;
		}
		if (customer.getAge() < 18 || customer.getAge() > 120) {
			response.setMessage("Age is Invalid");
			return response;
		}
		if (!Pattern.matches("[A-Z]{5}[0-9]{4}[A-Z]", customer.getPanNumber())) {
			response.setMessage("Pan Number is invalid");
			return response;
		}
		if (!Pattern.matches("^[a-zA-Z0-9-_+!#$%&*{|}.]+@[a-zA-Z0-9.-]+$", customer.getEmailId())) {
			response.setMessage("Email is invalid");
			return response;
		}
		if (!Pattern.matches("[6-9][0-9]{9}", customer.getContactNumber())) {
			response.setMessage("Contact Number is invalid");
			return response;
		}
		if (initialDeposit < 1000) {
			response.setMessage("Initial Deposit should be minimum Rs.1,000");
			return response;
		}
		boolean flag = false;
		if(accountType.equalsIgnoreCase("savings") || accountType.equalsIgnoreCase("current")) {
			flag = true;
		}
		if(!flag) {
			response.setMessage("Invalid Account Type");
			return response;
		}
		return customerService.addCustomer(customer, initialDeposit, accountType);
	}
}
