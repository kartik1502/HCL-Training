package org.hcltraining.bankapplication.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Transcation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transcationId;
	
	private long fromAccountNumber;
	
	private long toAccountNumber;
	
	private int amount;
	
	@CreationTimestamp
	private Date transcationDateTime;
	
}
