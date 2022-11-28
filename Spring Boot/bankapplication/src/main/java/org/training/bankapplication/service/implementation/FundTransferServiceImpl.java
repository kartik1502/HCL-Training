package org.training.bankapplication.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.bankapplication.dto.FundTransferDto;
import org.training.bankapplication.dto.Response;
import org.training.bankapplication.entity.Account;
import org.training.bankapplication.entity.Transcation;
import org.training.bankapplication.repository.AccountRepository;
import org.training.bankapplication.repository.TranscationRepository;
import org.training.bankapplication.service.FundTransferService;

@Service
public class FundTransferServiceImpl implements FundTransferService {
	
	@Autowired
	TranscationRepository transcationRepository;
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Response fundTransfer(FundTransferDto fundTransferDto) {
		
		Account fromAccount = accountRepository.findAccountByAccountNumber(fundTransferDto.getFromAccountNumber());
		Response response = new Response();
		if (fromAccount == null) {
			response.setMessage("Sender account is Invalid");
			return response;
		}
		Account toAccount = accountRepository.findAccountByAccountNumber(fundTransferDto.getToAccountNumber());
		if (toAccount == null) {
			response.setMessage("Receiver Account is Invalid");
			return response;
		}
		if (fundTransferDto.getAmount() > fromAccount.getBalance()) {
			response.setMessage("Insufficient Funds");
			return response;
		}

		fromAccount.setBalance(fromAccount.getBalance() - fundTransferDto.getAmount());
		toAccount.setBalance(toAccount.getBalance() + fundTransferDto.getAmount());

		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);

		Transcation transcation = new Transcation();
		
		transcation.setFromAccountNumber(fundTransferDto.getFromAccountNumber());
		transcation.setToAccountNumber(fundTransferDto.getToAccountNumber());
		transcation.setAmount(fundTransferDto.getAmount());
		transcation.setStatus("Debited from a/c no. "+fundTransferDto.getFromAccountNumber()+" and Credited to a/c no."+fundTransferDto.getToAccountNumber());

		transcationRepository.save(transcation);
		response.setMessage("Fund transfer was successfull");
		return response;
	}

}
