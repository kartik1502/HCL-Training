package org.training.bankapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.training.bankapplication.dto.FundTransferDto;
import org.training.bankapplication.entity.Transcation;
import org.training.bankapplication.service.TranscationService;

@RestController
@RequestMapping("/bank")
public class TranscationController {
	
	@Autowired
	TranscationService transcationService;
	
	@PostMapping("/fund-transfer")
	public String fundTransfer(@RequestBody FundTransferDto fundTransferDto ) {
		if (fundTransferDto.getFromAccountNumber() == fundTransferDto.getToAccountNumber())
			return "Can't Transfer to self Account";
		if(fundTransferDto.getAmount() <= 0)
			return "Amount should be greater than Rs.0";
		return transcationService.fundTransfer(fundTransferDto);
	}

	@GetMapping("/statement")
	public List<Transcation> getStatement(@RequestParam long accountNumber, @RequestParam String date) {
		return transcationService.statement(accountNumber, date);
//		return transcationService.getStatement(accountNumber, fromDate, toDate);
	}

}
