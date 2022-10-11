package org.training.customer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.training.customer.dto.Customer;

public class CustomerDao {

	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;
	private EntityTransaction entityTransaction = null;

	private void entity() {
		entityManagerFactory = Persistence.createEntityManagerFactory("kartik");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	public void saveCustomer(Customer customer) {
		entity();
		Customer cust = new Customer();
		cust.setName(customer.getName());
		cust.setEmailId(customer.getEmailId());
		cust.setPhoneNo(customer.getPhoneNo());
		entityTransaction.begin();
		entityManager.persist(cust);
		entityTransaction.commit();
	}

	public void updateCustomer(Customer customer, int id) {
		entity();
		Customer cust = entityManager.find(Customer.class, id);
		cust.setName(customer.getName());
		cust.setEmailId(customer.getEmailId());
		cust.setPhoneNo(customer.getPhoneNo());
		entityTransaction.begin();
		entityManager.merge	(cust);
		entityTransaction.commit();
	}

	public void deleteCustomer(Customer customer) {
		entity();
		Customer customer2 = entityManager.find(Customer.class, customer.getId());
		entityTransaction.begin();
		entityManager.remove(customer2);
		entityTransaction.commit();
	}

	public List<Customer> getCustomerByName(String name) {
		entity();
		Query query = entityManager.createQuery("select c from Customer c where name = :name");
		query.setParameter("name", name);
		List<Customer> customer = query.getResultList();
		return customer;
	}

	public List<Customer> getCustomersDetails() {
		entity();
		Query query = entityManager.createQuery("select c from Customer c");
		List<Customer> customer = query.getResultList();
		return customer;
	}

}
