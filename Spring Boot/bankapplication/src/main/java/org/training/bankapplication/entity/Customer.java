package org.training.bankapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	
	
	private String firstName;
	
	
	private String lastName;
	
	
	private int age;
	
	
	private String panNumber;
	
	
	private String emailId;
	
	
	private String contactNumber;

}
