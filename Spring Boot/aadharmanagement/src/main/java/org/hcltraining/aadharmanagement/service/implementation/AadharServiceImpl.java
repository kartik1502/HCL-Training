package org.hcltraining.aadharmanagement.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.hcltraining.aadharmanagement.dto.UserResponse;
import org.hcltraining.aadharmanagement.entity.Aadhar;
import org.hcltraining.aadharmanagement.repository.AadharRepository;
import org.hcltraining.aadharmanagement.service.AadharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AadharServiceImpl implements AadharService {

    @Autowired
    AadharRepository aadharRepository;
    
    @Override
    public Aadhar addAadhar(Aadhar aadhar) {
        return aadharRepository.save(aadhar);
    }
    
	@Override
	public List<Aadhar> getAllAadharUsers() {
		return aadharRepository.findAll();
	}

	@Override
	public List<Aadhar> getAadharByUserName(String firstName) {
		return aadharRepository.findAadharByUserFirstName(firstName);
	}

	@Override
	public List<Aadhar> updateAadharByUserName(String firstName, Aadhar aadhar) {
		List<Aadhar> aadhars = aadharRepository.findAadharByUserFirstName(firstName);
		for (Aadhar aadhar2 : aadhars) {
			if(aadhar.getAadharNumber() != null)
				aadhar2.setAadharNumber(aadhar.getAadharNumber());
			if(aadhar.getAddress() != null)
				aadhar2.setAddress(aadhar.getAddress());
			if(aadhar.getReceivedOn() != null)
				aadhar2.setReceivedOn(aadhar.getReceivedOn());
			if(aadhar.getUser().getFirstName() != null)
				aadhar2.getUser().setFirstName(aadhar.getUser().getFirstName());
			if(aadhar.getUser().getLastName() != null)
				aadhar2.getUser().setLastName(aadhar.getUser().getLastName());
			if(aadhar.getUser().getEmailId() != null)
				aadhar2.getUser().setEmailId(aadhar.getUser().getEmailId());
			aadharRepository.save(aadhar2);
		}
		return aadhars;
	}

	@Override
	public void deleteAadharByUserName(String firstName) {
		aadharRepository.deleteAadharByAadharNumber(firstName);
		
	}

	@Override
	public UserResponse getNumberOfAadharUsers(String aadharNumber) {
		return aadharRepository.getNumberOfAadharUsers(aadharNumber);
	}
}
