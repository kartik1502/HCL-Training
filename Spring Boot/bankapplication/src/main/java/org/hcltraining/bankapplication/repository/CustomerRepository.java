package org.hcltraining.bankapplication.repository;

import org.hcltraining.bankapplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
