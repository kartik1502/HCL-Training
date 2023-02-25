package org.training.onlinepetshop.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class PetCreate {
	
	@NotNull
	@Pattern(regexp = "[a-zA-Z ]+", message = "Invalid pet name")
	private String petName;
	
	@Min(1)
	private int quantity;

}
