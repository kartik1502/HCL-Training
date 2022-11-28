package org.training.bankapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.training.bankapplication.entity.Transcation;
import org.training.bankapplication.service.TranscationService;

@RestController

public class TranscationController {
	
	@Autowired
	TranscationService transcationService;

	@GetMapping("/statement")
	public List<Transcation> getStatement(@RequestParam long accountNumber, @RequestParam String date) {
		return transcationService.statement(accountNumber, date);
//		return transcationService.getStatement(accountNumber, fromDate, toDate);
	}

}
