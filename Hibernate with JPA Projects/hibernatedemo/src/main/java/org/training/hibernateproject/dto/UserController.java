package org.training.hibernateproject.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserController {
	
	public static void main(String[] args) {
		EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("kartik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		User user = new User();
		
		user.setId(4);
		user.setName("Adam");
		user.setEmail("adamsanadi6@gmail.com");
		
		entityTransaction.begin();
		
		entityManager.persist(user);
		
		entityTransaction.commit();
	}
}
