package org.training.onetoonemapping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.training.onetoonemapping.dto.Aadhar;
import org.training.onetoonemapping.dto.Person;

public class PersonDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kartik");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void savePerson(Person person, Aadhar aadhar) {
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(aadhar);
		entityTransaction.commit();
	}

	public Person getPersonDetails(int id) {
		Person person = entityManager.find(Person.class, id);
		return person;
	}

	public void deletePersonDetails(int id) {

		Person person = entityManager.find(Person.class, id);
		id = person.getAadhar().getId();
		Aadhar aadhar = entityManager.find(Aadhar.class, id);
		entityTransaction.begin();
		entityManager.remove(person);
		entityManager.remove(aadhar);
		entityTransaction.commit();
	}
	
	public void updatePersonDetails(int id,String name,long aadharNumber){
		Person person = entityManager.find(Person.class, id);
		id = person.getAadhar().getId();
		Aadhar aadhar = entityManager.find(Aadhar.class, id);
		person.setName(name);
		person.setAadhar(aadhar);
		aadhar.setAadharNumber(aadharNumber);
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(aadhar);
		entityTransaction.commit();
	}
}
