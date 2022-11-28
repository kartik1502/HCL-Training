package org.training.bankapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.training.bankapplication.dto.FundTransferDto;
import org.training.bankapplication.dto.Response;
import org.training.bankapplication.service.FundTransferService;

@RestController
public class FundTransferController {
	@Autowired
	FundTransferService fundTransferService;
	
	@PostMapping("/fund-transfer")
	public Response fundTransfer(@RequestBody FundTransferDto fundTransferDto ) {
		Response response = new Response();
		if (fundTransferDto.getFromAccountNumber() == fundTransferDto.getToAccountNumber()) {
			response.setMessage("Can't Transfer to self Account");
			return response;
		}
		if(fundTransferDto.getAmount() <= 0) {
			response.setMessage("Amount should be greater than Rs.0");
			return response;
		}
		return fundTransferService.fundTransfer(fundTransferDto);
	}

}
