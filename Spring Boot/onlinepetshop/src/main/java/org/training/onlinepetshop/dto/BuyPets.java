package org.training.onlinepetshop.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class BuyPets {

	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Invalid username")
	private String username;

	@NotNull
	@Pattern(regexp = "[a-zA-Z ]+", message = "Invalid pet name")
	private String petName;

	private int quantity;
}
