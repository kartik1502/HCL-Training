package org.training.onlinepetshop.service.implementation;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.training.onlinepetshop.dto.BuyPets;
import org.training.onlinepetshop.entity.Pet;
import org.training.onlinepetshop.entity.User;
import org.training.onlinepetshop.entity.UserPets;
import org.training.onlinepetshop.repository.UserPetsRepository;
import org.training.onlinepetshop.service.PetService;
import org.training.onlinepetshop.service.UserService;

@ExtendWith(SpringExtension.class)
class PurchaseServiceImplTest {

	@InjectMocks
	private PurchaseServiceImpl purchaseServiceImpl;
	
	@Mock
	private PetService petService;

	@Mock
	private UserPetsRepository userPetsRepository;

	@Mock
	private UserService userService;

	@Test
	void testBuySuccess() {
		
		Pet pet = new Pet();
		pet.setPetId(1);
		pet.setPetName("Bella");
		pet.setQuantity(1);
		when(petService.save((Pet) any())).thenReturn(pet);
		when(petService.findPetByPetName((String) any())).thenReturn(pet);

		Pet pet2 = new Pet();
		pet2.setPetId(1);
		pet2.setPetName("Bella");
		pet2.setQuantity(1);

		User user = new User();
		user.setFirstNme("Karthik");
		user.setLastName("Kulkarni");
		user.setPassword("Ka3k@1411");
		user.setRole("ROLE_USER");
		user.setStatus("Logged In");
		user.setUserId(1);
		user.setUserName("kartikkulkarni1411@gmail.com");

		UserPets userPets = new UserPets();
		userPets.setPet(pet2);
		userPets.setPurchasedDate(LocalDate.ofEpochDay(1L));
		userPets.setQuantity(1);
		userPets.setUser(user);
		userPets.setUserPetId(1);
		when(userPetsRepository.save((UserPets) any())).thenReturn(userPets);
		when(userService.findUserByUserName((String) any())).thenReturn(user);

		BuyPets buyPets = new BuyPets();
		buyPets.setPetName("Bella");
		buyPets.setQuantity(1);
		buyPets.setUsername("kartikkulkarni1411@gmail.com");
		assertSame(userPets, purchaseServiceImpl.buy(buyPets));
	}

	

}
