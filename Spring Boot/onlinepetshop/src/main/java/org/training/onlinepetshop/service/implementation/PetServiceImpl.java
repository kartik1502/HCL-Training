package org.training.onlinepetshop.service.implementation;

import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.onlinepetshop.dto.Constatns;
import org.training.onlinepetshop.dto.PetCreate;
import org.training.onlinepetshop.entity.Pet;
import org.training.onlinepetshop.entity.User;
import org.training.onlinepetshop.exception.AccessDenied;
import org.training.onlinepetshop.exception.UserNotFoundException;
import org.training.onlinepetshop.repository.PetRepository;
import org.training.onlinepetshop.service.PetService;
import org.training.onlinepetshop.service.UserService;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PetRepository petRepository;

	@Override
	public Pet addPet(@Valid PetCreate create, String username) {

		User user = userService.findUserByUserName(username);
		if (user == null) {
			throw new UserNotFoundException("User with username: " + username + " dose not exists");
		}
		if(!Objects.equals(user.getRole(), Constatns.ROLE_ADMIN)) {
			throw new AccessDenied("Unauthorized User");
		}
		if (!Objects.equals(user.getStatus(), Constatns.LOGGED_IN)) {
			throw new AccessDenied("Login Required");
		}
		Pet pet = petRepository.findPetByPetName(create.getPetName());
		if(pet == null) {
			Pet pet1 = new Pet();
			BeanUtils.copyProperties(create, pet1);
			return petRepository.save(pet1);
		}
		pet.setQuantity(create.getQuantity() + pet.getQuantity());
		return petRepository.save(pet);
	}

	@Override
	public List<Pet> getPets(String petName) {
		if(petName != null) {
			return petRepository.findByPetNameStartsWith(petName);
		}
		return petRepository.findAll();
	}

	@Override
	public Pet findPetByPetName(@NotNull String petName) {
		return petRepository.findPetByPetName(petName);
	}

	@Override
	public Pet save(Pet pet) {
		return petRepository.save(pet);
	}

}
