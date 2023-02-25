package org.training.onlinepetshop.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class UserPets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userPetId;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Pet pet;
	
	@CreationTimestamp
	private LocalDate purchasedDate;
	
	@Min(1)
	private int quantity;
}
