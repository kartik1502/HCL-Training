package org.training.hibernateproject.dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserNameParameterController {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kartik");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createQuery("select u from User u where u.name = :name");
		query.setParameter("name", "Karthik");
		List<User> users = query.getResultList();
		System.out.println(users);
	}
}
