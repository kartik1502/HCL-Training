package org.training.onlinepetshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

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
	@Pattern(regexp = "^[(a-z)(A-Z)(0-9)(@#$%&*!)]{8,}", message = "Invalid password pattern")
	private String password;

	@NotNull
	@Pattern(regexp = "^[A-Z_ ]+$", message = "Invalid Role")
	private String Role;

	private String status;

}
