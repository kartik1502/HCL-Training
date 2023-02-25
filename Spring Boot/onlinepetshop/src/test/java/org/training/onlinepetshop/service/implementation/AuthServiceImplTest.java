package org.training.onlinepetshop.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.training.onlinepetshop.dto.LoginUser;
import org.training.onlinepetshop.dto.UserCreate;
import org.training.onlinepetshop.entity.User;
import org.training.onlinepetshop.exception.PasswordDoseNotMatch;
import org.training.onlinepetshop.exception.UserAlreadyExists;
import org.training.onlinepetshop.exception.UserNotFoundException;
import org.training.onlinepetshop.repository.UserRepository;

@ExtendWith(SpringExtension.class)
class AuthServiceImplTest {

	@InjectMocks
	private AuthServiceImpl serviceImpl;

	@Mock
	private UserRepository userRepository;

	@Test
	void testRegisterUserExists() {
		
		User user = new User();
		user.setFirstNme("Karthik");
		user.setLastName("Kulkarni");
		user.setPassword("Ka3k@1411");
		user.setRole("ROLE_USER");
		user.setStatus("Logged Out");
		user.setUserId(1);
		user.setUserName("kartikkulkarni1411@gmail.com");

		User user1 = new User();
		user.setFirstNme("Karthik");
		user.setLastName("Kulkarni");
		user.setPassword("Ka3k@1411");
		user.setRole("ROLE_USER");
		user.setStatus("Logged Out");
		user.setUserId(1);
		user.setUserName("kartikkulkarni1411@gmail.com");
		when(userRepository.save((User) any())).thenReturn(user);
		when(userRepository.findUserByUserName((String) any())).thenReturn(user1);

		UserCreate userCreate = new UserCreate();
		userCreate.setFirstNme("Karthik");
		userCreate.setLastName("Kulkarni");
		userCreate.setPassword("Ka3k@1411");
		userCreate.setRepeatPassword("Ka3k@1411");
		userCreate.setRole("ROLE_USER");
		userCreate.setUserName("kartikkulkarni1411@gmail.com");
		assertThrows(UserAlreadyExists.class, () -> serviceImpl.register(userCreate));
		verify(userRepository).findUserByUserName((String) any());
	}


	@Test
	void testLoginSuccessfull() {
		User user = new User();
		user.setFirstNme("Karthik");
		user.setLastName("Kulkarni");
		user.setPassword("Ka3k@1411");
		user.setRole("ROLE_USER");
		user.setStatus("Logged Out");
		user.setUserId(1);
		user.setUserName("kartikkulkarni1411@gmail.com");

		User user1 = new User();
		user1.setFirstNme("Karthik");
		user1.setLastName("Kulkarni");
		user1.setPassword("Ka3k@1411");
		user1.setRole("ROLE_USER");
		user1.setStatus("Logged Out");
		user1.setUserId(1);
		user1.setUserName("kartikkulkarni1411@gmail.com");
		when(userRepository.save((User) any())).thenReturn(user1);
		when(userRepository.findUserByUserName((String) any())).thenReturn(user);

		LoginUser loginUser = new LoginUser();
		loginUser.setPassword("Ka3k@1411");
		loginUser.setUsername("kartikkulkarni1411@gmail.com");
		assertEquals("Logged in successfully", serviceImpl.login(loginUser).getMessage());
		verify(userRepository).save((User) any());
		verify(userRepository).findUserByUserName((String) any());
	}


	@Test
	void testLoginPasswordNotMatch() {
		User user = mock(User.class);
		user.setFirstNme("Karthik");
		user.setLastName("Kulkarni");
		user.setPassword("Ka3k@1411");
		user.setRole("ROLE_USER");
		user.setStatus("Logged Out");
		user.setUserId(1);
		user.setUserName("kartikkulkarni1411@gmail.com");


		User user1 = new User();
		user1.setFirstNme("Karthik");
		user1.setLastName("Kulkarni");
		user1.setPassword("Ka3k@1411");
		user1.setRole("ROLE_USER");
		user1.setStatus("Logged Out");
		user1.setUserId(1);
		user1.setUserName("kartikkulkarni1411@gmail.com");
		when(userRepository.save((User) any())).thenReturn(user1);
		when(userRepository.findUserByUserName((String) any())).thenReturn(user);

		LoginUser loginUser = new LoginUser();
		loginUser.setPassword("Ka3k1411");
		loginUser.setUsername("kartikkulkarni1411@gmail.com");
		assertThrows(PasswordDoseNotMatch.class, () -> serviceImpl.login(loginUser));
		verify(userRepository).findUserByUserName((String) any());
	}

	@Test
	void testLogoutSuccess() {
		User user = new User();
		user.setFirstNme("Karthik");
		user.setLastName("Kulkarni");
		user.setPassword("Ka3k@1411");
		user.setRole("ROLE_USER");
		user.setStatus("Logged In");
		user.setUserId(1);
		user.setUserName("kartikkulkarni1411@gmail.com");

		User user1 = new User();
		user1.setFirstNme("Karthik");
		user1.setLastName("Kulkarni");
		user1.setPassword("Ka3k@1411");
		user1.setRole("ROLE_USER");
		user1.setStatus("Logged In");
		user1.setUserId(1);
		user1.setUserName("kartikkulkarni1411@gmail.com");		
		when(userRepository.save((User) any())).thenReturn(user1);
		when(userRepository.findUserByUserName((String) any())).thenReturn(user);
		assertEquals("Logged out successfully", serviceImpl.logout("kartikkulkarni1411@gmail.com").getMessage());
		verify(userRepository).save((User) any());
		verify(userRepository).findUserByUserName((String) any());
	}

	@Test
	void testLogoutUserNotFound() {
		User user = new User();
		user.setFirstNme("Karthik");
		user.setLastName("Kulkarni");
		user.setPassword("Ka3k@1411");
		user.setRole("ROLE_USER");
		user.setStatus("Logged In");
		user.setUserId(1);
		user.setUserName("kartikkulkarni1411@gmail.com");
		when(userRepository.save((User) any())).thenThrow(new UserNotFoundException("User not found"));
		when(userRepository.findUserByUserName((String) any())).thenReturn(user);
		assertThrows(UserNotFoundException.class, () -> serviceImpl.logout("User"));
		verify(userRepository).save((User) any());
		verify(userRepository).findUserByUserName((String) any());
	}

}
