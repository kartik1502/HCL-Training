package org.training.onlinepetshop.service.implementation;

import java.util.Objects;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.onlinepetshop.dto.BuyPets;
import org.training.onlinepetshop.dto.Constatns;
import org.training.onlinepetshop.entity.Pet;
import org.training.onlinepetshop.entity.User;
import org.training.onlinepetshop.entity.UserPets;
import org.training.onlinepetshop.exception.AccessDenied;
import org.training.onlinepetshop.exception.NoSuchPetExists;
import org.training.onlinepetshop.exception.UserNotFoundException;
import org.training.onlinepetshop.repository.UserPetsRepository;
import org.training.onlinepetshop.service.PetService;
import org.training.onlinepetshop.service.PurchaseService;
import org.training.onlinepetshop.service.UserService;

@Service
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	private UserService userService;
	
	@Autowired
	private PetService petService;
	
	@Autowired
	private UserPetsRepository userPetsRepository;
	
	@Override
	public UserPets buy(@Valid BuyPets pets) {
		
		User user = userService.findUserByUserName(pets.getUsername());
		if(user == null) {
			throw new UserNotFoundException("User with username: " + pets.getUsername() + " dose not exists");
		}
		if(Objects.equals(user.getStatus(), Constatns.LOGGED_OUT) || user.getStatus() == null) {
			throw new AccessDenied("Login Required");
		}
		Pet pet = petService.findPetByPetName(pets.getPetName());
		if(pet == null || pet.getQuantity() < 1) {
			throw new NoSuchPetExists("Pet with name: "+pets.getPetName()+" dose not exists");
		}
		pet.setQuantity(pet.getQuantity() - pets.getQuantity());
		petService.save(pet);
		UserPets userPets = new UserPets();
		userPets.setQuantity(pets.getQuantity());
		userPets.setUser(user);
		userPets.setPet(pet);
		return userPetsRepository.save(userPets);
	}

}
