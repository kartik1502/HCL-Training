package org.training.onlinepetshop.repository;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.onlinepetshop.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByUserName(@NotNull String userName);

}
