package org.training.foodorderapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.foodorderapplication.config.JwtTokenUtil;
import org.training.foodorderapplication.dto.AuthenticationRequest;
import org.training.foodorderapplication.dto.AuthenticationResponse;
import org.training.foodorderapplication.dto.ResponseDto;
import org.training.foodorderapplication.dto.UserDto;
import org.training.foodorderapplication.entity.User;
import org.training.foodorderapplication.service.UserService;


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
