package org.training.onlinepetshop.dto;

import lombok.Data;

@Data
public class Response {

	private String message;

	public Response(String message) {
		super();
		this.message = message;
	}
	
	
}
