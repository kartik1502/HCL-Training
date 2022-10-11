package org.training.manytomanybidirectional.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.training.manytomanybidirectional.dto.Car;
import org.training.manytomanybidirectional.dto.Features;

public class CarDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kartik");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveCarFeatures(List<Car> cars,List<Features> features){
		entityTransaction.begin();
		for (Car car : cars) {
			for (Features features2 : car.getFeatures()) {
				entityManager.persist(features2);
				features2.setCars(cars);
			}
			entityManager.persist(car);
		}
		entityTransaction.commit();
	}
}
