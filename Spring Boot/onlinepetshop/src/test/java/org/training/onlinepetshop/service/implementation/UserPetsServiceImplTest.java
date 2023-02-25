package org.training.onlinepetshop.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.training.onlinepetshop.dto.History;
import org.training.onlinepetshop.entity.Pet;
import org.training.onlinepetshop.entity.User;
import org.training.onlinepetshop.entity.UserPets;
import org.training.onlinepetshop.repository.UserPetsRepository;

@ExtendWith(SpringExtension.class)
class UserPetsServiceImplTest {
	
	@InjectMocks
    private UserPetsServiceImpl userPetsServiceImpl;

	@Mock
    private UserPetsRepository userPetsRepository;

	@Test
    void testHistoryEmptyList() {
        when(userPetsRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(userPetsServiceImpl.history().isEmpty());
        verify(userPetsRepository).findAll();
    }

    @Test
    void testHistoryListSizeOne() {
        Pet pet = new Pet();
        pet.setPetId(1);
        pet.setPetName("Bella");
        pet.setQuantity(1);

        User user = new User();
        user.setFirstNme("Karthik");
        user.setLastName("Kulkarni");
        user.setPassword("Ka3k@1411");
        user.setRole("ROLE_USER");
        user.setStatus("Logged In");
        user.setUserId(1);
        user.setUserName("kartikkulkarni1411@gmail.com");

        UserPets userPets = new UserPets();
        userPets.setPet(pet);
        userPets.setPurchasedDate(LocalDate.ofEpochDay(1L));
        userPets.setQuantity(1);
        userPets.setUser(user);
        userPets.setUserPetId(1);

        ArrayList<UserPets> userPetsList = new ArrayList<>();
        userPetsList.add(userPets);
        when(userPetsRepository.findAll()).thenReturn(userPetsList);
        List<History> actualHistoryResult = userPetsServiceImpl.history();
        assertEquals(1, actualHistoryResult.size());
        History getResult = actualHistoryResult.get(0);
        assertEquals("Bella", getResult.getPetName());
        assertEquals("Karthik Kulkarni", getResult.getUserName());
        assertEquals(1, getResult.getQuantity());
        assertEquals(1, getResult.getPurchaseId());
        assertEquals("1970-01-02", getResult.getPurchaseDate().toString());
        verify(userPetsRepository).findAll();
    }

    @Test
    void testHistoryListSuccess() {
        Pet pet = new Pet();
        pet.setPetId(1);
        pet.setPetName("Bella");
        pet.setQuantity(1);

        User user = new User();
        user.setFirstNme("Karthik");
        user.setLastName("Kulkarni");
        user.setPassword("Ka3k@1411");
        user.setRole("ROLE_USER");
        user.setStatus("Logged In");
        user.setUserId(1);
        user.setUserName("kartikkulkarni1411@gmail.com");

        UserPets userPets = new UserPets();
        userPets.setPet(pet);
        userPets.setPurchasedDate(LocalDate.ofEpochDay(1L));
        userPets.setQuantity(1);
        userPets.setUser(user);
        userPets.setUserPetId(1);

        Pet pet1 = new Pet();
        pet1.setPetId(2);
        pet1.setPetName("Wolfs Bane");
        pet1.setQuantity(1);

        User user1 = new User();
        user1.setFirstNme("Kishan");
        user1.setLastName("Kulkarni");
        user1.setPassword("Kishan@1502");
        user1.setRole("ROLE_USER");
        user1.setStatus("Logged Out");
        user1.setUserId(2);
        user1.setUserName("kulkarnikishan@1502");

        UserPets userPets1 = new UserPets();
        userPets1.setPet(pet1);
        userPets1.setPurchasedDate(LocalDate.ofEpochDay(1L));
        userPets1.setQuantity(1);
        userPets1.setUser(user1);
        userPets1.setUserPetId(2);

        ArrayList<UserPets> userPetsList = new ArrayList<>();
        userPetsList.add(userPets1);
        userPetsList.add(userPets);
        when(userPetsRepository.findAll()).thenReturn(userPetsList);
        List<History> actualHistoryResult = userPetsServiceImpl.history();
        assertEquals(2, actualHistoryResult.size());
        History getResult = actualHistoryResult.get(0);
        assertEquals("Kishan Kulkarni", getResult.getUserName());
        assertEquals(1, getResult.getQuantity());
        assertEquals("1970-01-02", getResult.getPurchaseDate().toString());
        assertEquals("Wolfs Bane", getResult.getPetName());
        assertEquals(2, getResult.getPurchaseId());
        History getResult1 = actualHistoryResult.get(1);
        assertEquals("Karthik Kulkarni", getResult1.getUserName());
        assertEquals(1, getResult1.getQuantity());
        assertEquals(1, getResult1.getPurchaseId());
        assertEquals("1970-01-02", getResult1.getPurchaseDate().toString());
        assertEquals("Bella", getResult1.getPetName());
        
       
        verify(userPetsRepository).findAll();
    }
}
