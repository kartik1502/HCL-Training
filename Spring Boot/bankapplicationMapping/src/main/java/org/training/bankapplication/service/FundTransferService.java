package org.training.bankapplication.service;

import org.training.bankapplication.dto.FundTransferDto;
import org.training.bankapplication.dto.Response;

public interface FundTransferService {
	
	Response fundTransfer(FundTransferDto fundTransferDto);

}
