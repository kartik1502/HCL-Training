package org.training.onlinepetshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.training.onlinepetshop.dto.LoginUser;
import org.training.onlinepetshop.dto.Response;
import org.training.onlinepetshop.dto.UserCreate;
import org.training.onlinepetshop.entity.User;
import org.training.onlinepetshop.service.AuthService;

@RestController
@RequestMapping("/petshop")
public class LoginController {

	@Autowired
	private AuthService service;

	@PostMapping("/register")
	public ResponseEntity<User> register(@Valid @RequestBody UserCreate create) {
		return new ResponseEntity<>(service.register(create), HttpStatus.OK);
	}

	@PutMapping("/login")
	public ResponseEntity<Response> login(@Valid @RequestBody LoginUser user) {
		return new ResponseEntity<>(service.login(user), HttpStatus.OK);
	}

	@PutMapping("/logout")
	public ResponseEntity<Response> logout(@Valid @RequestParam String user) {
		return new ResponseEntity<>(service.logout(user), HttpStatus.OK);
	}

}
