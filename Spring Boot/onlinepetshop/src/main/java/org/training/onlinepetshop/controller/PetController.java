package org.training.onlinepetshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.training.onlinepetshop.dto.PetCreate;
import org.training.onlinepetshop.entity.Pet;
import org.training.onlinepetshop.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	PetService service;
	
	@PostMapping
	public ResponseEntity<Pet> addPet(@Valid @RequestBody PetCreate create,@RequestParam String username){
		return new ResponseEntity<>(service.addPet(create, username), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Pet>> getPets(@RequestParam(required = false) String petName){
		return new ResponseEntity<>(service.getPets(petName), HttpStatus.OK);
	}
	
}
