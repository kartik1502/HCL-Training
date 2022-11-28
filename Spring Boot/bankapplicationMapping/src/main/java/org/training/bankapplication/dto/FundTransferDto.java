package org.training.bankapplication.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FundTransferDto {
	
	long fromAccountNumber;
	
	long toAccountNumber;
	
	int amount;
	
	

}
