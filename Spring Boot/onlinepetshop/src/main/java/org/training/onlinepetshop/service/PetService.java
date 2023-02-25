package org.training.onlinepetshop.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.training.onlinepetshop.dto.PetCreate;
import org.training.onlinepetshop.entity.Pet;

public interface PetService {

	Pet addPet(@Valid PetCreate create, String username);

	List<Pet> getPets(String petName);

	Pet findPetByPetName(@NotNull String petName);

	Pet save(Pet pet);

}
