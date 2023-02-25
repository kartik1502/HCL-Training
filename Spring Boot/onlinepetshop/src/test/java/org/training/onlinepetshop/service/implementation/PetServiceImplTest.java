package org.training.onlinepetshop.service.implementation;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.training.onlinepetshop.dto.PetCreate;
import org.training.onlinepetshop.entity.Pet;
import org.training.onlinepetshop.entity.User;
import org.training.onlinepetshop.exception.AccessDenied;
import org.training.onlinepetshop.exception.UserNotFoundException;
import org.training.onlinepetshop.repository.PetRepository;
import org.training.onlinepetshop.service.UserService;

@ExtendWith(SpringExtension.class)
class PetServiceImplTest {

	@InjectMocks
	private PetServiceImpl petServiceImpl;

	@Mock
	private UserService userService;
	
	@Mock
	private PetRepository petRepository;


	@Test
	void testAddPetAccessDenied() {
		User user = new User();
		user.setFirstNme("Karthik");
		user.setLastName("Kulkarni");
		user.setPassword("Ka3k@1411");
		user.setRole("ROLE_ADMIN");
		user.setStatus("Logged Out");
		user.setUserId(1);
		user.setUserName("kartikkulkarni1411@gmail.com");
		when(userService.findUserByUserName((String) any())).thenReturn(user);

		PetCreate petCreate = new PetCreate();
		petCreate.setPetName("Bella");
		petCreate.setQuantity(1);
		assertThrows(AccessDenied.class, () -> petServiceImpl.addPet(petCreate, "kartikkulkarni1411@gmail.com"));
		verify(userService).findUserByUserName((String) any());
	}


	@Test
	void testAddPetUserNotFound() {
		when(userService.findUserByUserName((String) any())).thenThrow(new UserNotFoundException("An error occurred"));

		PetCreate petCreate = new PetCreate();
		petCreate.setPetName("Bella");
		petCreate.setQuantity(1);
		assertThrows(UserNotFoundException.class, () -> petServiceImpl.addPet(petCreate, "kygandudi@gmail.com"));
		verify(userService).findUserByUserName((String) any());
	}

	@Test
	void testAddPetSuccess() {
		Pet pet = new Pet();
		pet.setPetId(123);
		pet.setPetName("Bella");
		pet.setQuantity(1);
		when(petRepository.save((Pet) any())).thenReturn(pet);

		User user = new User();
		user.setFirstNme("Karthik");
		user.setLastName("Kulkarni");
		user.setPassword("Ka3k@1411");
		user.setRole("ROLE_ADMIN");
		user.setStatus("Logged In");
		user.setUserId(1);
		user.setUserName("kartikkulkarni1411@gmail.com");
		when(userService.findUserByUserName((String) any())).thenReturn(user);

		PetCreate petCreate = new PetCreate();
		petCreate.setPetName("Bella");
		petCreate.setQuantity(1);
		assertSame(pet, petServiceImpl.addPet(petCreate, "kartikkulkarni1411@gmail.com"));
		verify(petRepository).save((Pet) any());
		verify(userService).findUserByUserName((String) any());
	}

}
