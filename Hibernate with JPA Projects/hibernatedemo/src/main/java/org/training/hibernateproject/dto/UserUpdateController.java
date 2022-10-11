package org.training.hibernateproject.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserUpdateController {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kartik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		User user = entityManager.find(User.class, 1);
		
		user.setName("Arya");
		user.setEmail("arya1234@gmail.com");
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
	}

}
