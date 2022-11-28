package org.training.bankapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.bankapplication.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	List<Customer> findCustomerByPanNumber(String panNumber);

}
