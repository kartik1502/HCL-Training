package org.training.onlinepetshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.onlinepetshop.dto.BuyPets;
import org.training.onlinepetshop.entity.UserPets;
import org.training.onlinepetshop.service.PurchaseService;

@RestController
@RequestMapping("/buy")
public class BuyController {

	@Autowired
	PurchaseService service;
	
	@PostMapping
	public ResponseEntity<UserPets> buy(@Valid @RequestBody BuyPets pets){
		return new ResponseEntity<>(service.buy(pets), HttpStatus.OK);
	}
}
