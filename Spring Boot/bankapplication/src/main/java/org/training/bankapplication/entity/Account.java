package org.training.bankapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountId;
	
	private long accountNumber;
	
	
	private String accountType;
	
	private int balance;
	
//	@OneToOne
//	@JoinColumn(name = "custmerId", referencedColumnName = "customerId")
	private long customerId;
	
	
	
}
