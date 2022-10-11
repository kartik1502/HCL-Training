package org.training.manytoonemapping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.training.manytoonemapping.dto.Building;
import org.training.manytoonemapping.dto.College;

public class CollegeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kartik");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveBuilding(College college, List<Building> buildings) {
		entityTransaction.begin();
		for (Building building : buildings) {
			building.setCollege(college);
			entityManager.persist(building);
		}
		entityTransaction.commit();
	}
}
