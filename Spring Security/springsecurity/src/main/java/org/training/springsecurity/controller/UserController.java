package org.training.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.springsecurity.entity.User;
import org.training.springsecurity.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

}
