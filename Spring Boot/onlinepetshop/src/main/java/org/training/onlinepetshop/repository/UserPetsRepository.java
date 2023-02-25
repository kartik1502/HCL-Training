package org.training.onlinepetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.onlinepetshop.entity.UserPets;

public interface UserPetsRepository extends JpaRepository<UserPets, Integer> {

}
