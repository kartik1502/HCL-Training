package org.hcltraining.mvcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hcltraining.mvcrud.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CustomerDaoImplementation {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	
	public Customer saveCustomer(Customer customer) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		
		return customer;
	}
	
	public Customer getCustomerById(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Customer.class, id);
	}
	
	public List<Customer> getCustomers(){
		
		entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select c from Customer c");
		List<Customer> customers = query.getResultList();
		return customers;
	}
	
	public Customer updateTeacher(Customer teacher) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		Customer t1 = entityManager.find(Customer.class, teacher.getId());
		entityTransaction.begin();
		entityManager.merge(teacher);
		entityTransaction.commit();
		return t1;		
	}
	
	public void deleteCustomer(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
		Customer customer = entityManager.find(Customer.class, id);
		entityTransaction.begin();
		entityManager.remove(customer);
		entityTransaction.commit();
	}
	

}
