package org.training.bankapplication.service.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public List<Transcation> statement(long accountNumber, String date) {
		LocalDate endDate = null;
		
		DateUtil util = new DateUtil();
		
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
