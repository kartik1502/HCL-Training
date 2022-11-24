package org.hcltraining.aadharmanagement.service;

import java.util.List;

import org.hcltraining.aadharmanagement.dto.UserResponse;
import org.hcltraining.aadharmanagement.entity.Aadhar;

public interface AadharService {

    Aadhar addAadhar(Aadhar aadhar);

	List<Aadhar> getAllAadharUsers();

	List<Aadhar> getAadharByUserName(String firstName);

	List<Aadhar> updateAadharByUserName(String firstName, Aadhar aadhar);

	void deleteAadharByUserName(String aadharNumber);

	UserResponse getNumberOfAadharUsers(String startDate);
}
