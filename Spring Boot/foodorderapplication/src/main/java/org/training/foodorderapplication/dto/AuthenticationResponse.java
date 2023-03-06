package org.training.foodorderapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

	private int statusCode;
	
	private String message;
	
	private String jwtToken;
}
