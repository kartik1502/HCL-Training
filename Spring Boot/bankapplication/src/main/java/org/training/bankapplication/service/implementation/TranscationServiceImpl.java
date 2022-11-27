package org.training.bankapplication.service.implementation;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.bankapplication.dto.FundTransferDto;
import org.training.bankapplication.entity.Account;
import org.training.bankapplication.entity.Transcation;
import org.training.bankapplication.repository.AccountRepository;
import org.training.bankapplication.repository.TranscationRepository;
import org.training.bankapplication.service.TranscationService;
import org.training.bankapplication.util.DateUtil;

@Service
public class TranscationServiceImpl implements TranscationService {

	
	@Autowired
	TranscationRepository transcationRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public String fundTransfer(FundTransferDto fundTransferDto) {
		Account fromAccount = accountRepository.findAccountByAccountNumber(fundTransferDto.getFromAccountNumber());
		if (fromAccount == null)
			return "Sender account is Invalid";

		Account toAccount = accountRepository.findAccountByAccountNumber(fundTransferDto.getToAccountNumber());
		if (toAccount == null)
			return "Receiver Account is Invalid";

		if (fundTransferDto.getAmount() > fromAccount.getBalance())
			return "Insufficient Funds";

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

		return "Fund transfer was successfull";
	}

	
	DateUtil util = new DateUtil();

	@Override
	public List<Transcation> getStatement(long accountNumber, String fromDate, String toDate) {
		
		LocalDate startDate = null;
		LocalDate endDate = null;

		if(Pattern.matches("^([0-9]{2})-([0-9]{2})-[0-9]{4}$", fromDate)) {
			startDate = LocalDate.parse(util.localDateFormatter(fromDate));
		}
		else if (!Pattern.matches("^([0-9]{4})-([0-9]{2})-[0-9]{2}$", fromDate))
			startDate = util.dateConverter(fromDate);
		else
			startDate = LocalDate.parse(fromDate);
		
		if(Pattern.matches("^([0-9]{2})-([0-9]{2})-[0-9]{4}$", toDate)) {
			endDate = LocalDate.parse(util.localDateFormatter(toDate));
		}
		else if (!Pattern.matches("^([0-9]{4})-([0-9]{2})-[0-9]{2}$", toDate))
			endDate = util.dateConverter(toDate);
		else
			endDate = LocalDate.parse(toDate);
		
		return transcationRepository.findAllByTranscationDateTimeBetweenAndFromAccountNumberOrToAccountNumber(
				Date.valueOf(startDate), Date.valueOf(endDate), accountNumber, accountNumber);

	}

	@Override
	public List<Transcation> statement(long accountNumber, String date) {
//		LocalDate startDate = null;
		LocalDate endDate = null;
		
		
		if(Pattern.matches("^([0-9]{2})-([0-9]{2})-[0-9]{4}$", date)) {
			endDate = LocalDate.parse(util.localDateFormatter(date));
		}
		else if (!Pattern.matches("^([0-9]{4})-([0-9]{2})-[0-9]{2}$", date))
			endDate = util.dateConverter(date);
		else
			endDate = LocalDate.parse(date);
		return transcationRepository.statement(accountNumber, endDate.getMonthValue() ,endDate.getYear() );
	}

	

}
