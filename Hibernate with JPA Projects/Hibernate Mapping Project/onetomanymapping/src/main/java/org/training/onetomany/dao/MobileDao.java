package org.training.onetomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.training.onetomany.dto.Mobile;
import org.training.onetomany.dto.Sim;

public class MobileDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kartik");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveMobileSim(Mobile mobile, List<Sim> sims) {
		entityTransaction.begin();
		entityManager.persist(mobile);
		for (Sim sim : sims) {
			entityManager.persist(sim);
		}
		entityTransaction.commit();
	}

	public Mobile getMobileDetailsById(int id) {
		Mobile mobile = entityManager.find(Mobile.class, id);
		return mobile;
	}

	public void updateMobileSimDetails(int id, String mobileName, String oldSimProvider,String newSimProvider) {
		entityTransaction.begin();
		Mobile mobile = entityManager.find(Mobile.class, id);
		mobile.setName(mobileName);
		for (Sim sim : mobile.getSims()) {
			if(sim.getName().equals(oldSimProvider)){
			sim.setName(newSimProvider);
			entityManager.persist(sim);
			}
		}
		entityManager.persist(mobile);
		entityTransaction.commit();
	}

	public void deleteMobileSimDetails(int id) {
		Mobile mobile = entityManager.find(Mobile.class, id);
		entityTransaction.begin();
		if(mobile.getSims() != null){
			for (Sim sim : mobile.getSims()) {
				entityManager.remove(sim);
			}
		}
		entityManager.remove(mobile);
		entityTransaction.commit();

	}
}
