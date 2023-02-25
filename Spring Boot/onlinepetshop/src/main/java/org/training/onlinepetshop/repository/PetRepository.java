package org.training.onlinepetshop.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.onlinepetshop.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {

	List<Pet> findByPetNameStartsWith(String petName);

	Pet findPetByPetName(@NotNull String petName);

}
