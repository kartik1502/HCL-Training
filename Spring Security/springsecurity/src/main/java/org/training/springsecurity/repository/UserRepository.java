package org.training.springsecurity.repository;

import java.util.Optional;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.springsecurity.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	
	Optional<User> findByUserEmailId(@NotNull String userEmailId);

}
