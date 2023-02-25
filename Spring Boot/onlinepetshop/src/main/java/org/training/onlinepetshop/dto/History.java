package org.training.onlinepetshop.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class History {
	
	private int purchaseId;
	
	private String userName;
	
	private String petName;
	
	private LocalDate purchaseDate;
	
	private int quantity;

}
