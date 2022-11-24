package org.hcltraining.aadharmanagement.repository;

import org.hcltraining.aadharmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByFirstName(String firstName);
    
}
