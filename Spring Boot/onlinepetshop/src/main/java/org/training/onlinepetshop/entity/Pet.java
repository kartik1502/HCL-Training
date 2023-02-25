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
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petId;
	
	@NotNull
	@Pattern(regexp = "[a-zA-Z ]+", message = "Invalid pet name")
	private String petName;
	
	private int quantity;
}
