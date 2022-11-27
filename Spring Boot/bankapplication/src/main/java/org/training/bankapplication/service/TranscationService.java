package org.training.bankapplication.service;

import java.util.List;

import org.training.bankapplication.dto.FundTransferDto;
import org.training.bankapplication.entity.Transcation;


public interface TranscationService {


	List<Transcation> getStatement(long accountNumber, String fromDate, String toDate);


	String fundTransfer(FundTransferDto fundTransferDto);


	List<Transcation> statement(long accountNumber, String date);
}
