package org.training.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.springsecurity.config.JwtTokenUtil;
import org.training.springsecurity.dto.AuthenticationRequest;
import org.training.springsecurity.dto.AuthenticationResponse;
import org.training.springsecurity.dto.ResponseDto;
import org.training.springsecurity.dto.UserDto;
import org.training.springsecurity.entity.User;
import org.training.springsecurity.service.UserService;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	private UserService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
		final User user = service.findByusername(request.getUserName());
		final String jwtToken = jwtTokenUtil.generateToken(user);
		return new ResponseEntity<>(new AuthenticationResponse(200, "success", jwtToken), HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<ResponseDto> addUser(@RequestBody UserDto userDto) {

		return new ResponseEntity<>(service.addUser(userDto), HttpStatus.OK);

	}

	
	
	
}
