package org.hcltraining.aadharmanagement.repository;

import java.util.List;

import org.hcltraining.aadharmanagement.dto.UserResponse;
import org.hcltraining.aadharmanagement.entity.Aadhar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AadharRepository extends JpaRepository<Aadhar, Integer> {

	List<Aadhar> findAadharByUserFirstName(String firstName);

	void deleteAadharByAadharNumber(String firstName);
	
	@Query("select new org.hcltraining.aadharmanagement.dto.UserResponse(count(*), a.aadharNumber) from Aadhar a  where aadharNumber =:aadharNumber")
	UserResponse getNumberOfAadharUsers(String aadharNumber);

	

	
}
