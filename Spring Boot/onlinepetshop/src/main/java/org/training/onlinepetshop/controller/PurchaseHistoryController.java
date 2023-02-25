package org.training.onlinepetshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.onlinepetshop.dto.History;
import org.training.onlinepetshop.service.UserPetsService;

@RestController
@RequestMapping("/history")
public class PurchaseHistoryController {

	@Autowired
	private UserPetsService service;
	
	@GetMapping
	public ResponseEntity<List<History>> history(){
		return new ResponseEntity<>(service.history(), HttpStatus.OK);
	}
}
