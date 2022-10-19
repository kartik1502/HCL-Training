package org.hcltraining.mvcrud.service;

import java.util.List;

//import org.hcltraining.mvcrud.dao.CustomerDao;
import org.hcltraining.mvcrud.dao.CustomerDaoImplementation;
import org.hcltraining.mvcrud.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CustomerServiceImplementation{

//	@Autowired
//	CustomerDao customerDao;
	
	@Autowired
	CustomerDaoImplementation implementation;
	
	public Customer saveCustomer(Customer customer) {
		
		return implementation.saveCustomer(customer);
	}
	
	public Customer getCustomerById(int id) {
		return implementation.getCustomerById(id);
	}
	
	public List<Customer> getCustomers(){
		
		return implementation.getCustomers();
	}
	
	public Customer updateCustomer(Customer teacher) {
		return implementation.updateTeacher(teacher);
	}
	
	public void deleteCustomer(int id) {
		implementation.deleteCustomer(id);
	}
	
	

}
