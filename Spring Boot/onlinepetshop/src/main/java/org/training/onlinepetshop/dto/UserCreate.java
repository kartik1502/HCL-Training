package org.training.onlinepetshop.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserCreate {

	@NotNull
	@Pattern(regexp = "[a-zA-Z ]+", message = "Invalid first name")
	private String firstNme;

	@NotNull
	@Pattern(regexp = "[a-zA-Z ]+", message = "Invalid last name")
	private String lastName;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Invalid username")
	private String userName;

	@NotNull
	@Pattern(regexp = "[A-Z_ ]+", message = "Invalid Role")
	private String role;

	@NotNull
	@Pattern(regexp = "^[(a-z)(A-Z)(0-9)(@#$%&*!)]{8,}", message = "Invalid password pattern")
	private String password;

	@NotNull
	@Pattern(regexp = "^[(a-z)(A-Z)(0-9)(@#$%&*!)]{8,}", message = "Invalid password pattern")
	private String repeatPassword;

}
