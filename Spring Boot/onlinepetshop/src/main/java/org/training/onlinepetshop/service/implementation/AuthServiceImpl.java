package org.training.onlinepetshop.service.implementation;

import static org.training.onlinepetshop.dto.Constatns.LOGGED_IN;
import static org.training.onlinepetshop.dto.Constatns.LOGGED_OUT;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.onlinepetshop.dto.LoginUser;
import org.training.onlinepetshop.dto.Response;
import org.training.onlinepetshop.dto.UserCreate;
import org.training.onlinepetshop.entity.User;
import org.training.onlinepetshop.exception.PasswordDoseNotMatch;
import org.training.onlinepetshop.exception.UserAlreadyExists;
import org.training.onlinepetshop.exception.UserNotFoundException;
import org.training.onlinepetshop.repository.UserRepository;
import org.training.onlinepetshop.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(UserCreate create) {

		if (userRepository.findUserByUserName(create.getUserName()) != null) {
			throw new UserAlreadyExists("User with username: " + create.getUserName() + " already exists");
		}
		if (!Objects.equals(create.getPassword(), create.getRepeatPassword())) {
			throw new PasswordDoseNotMatch("Password dose not match");
		}
		User user = new User();
		BeanUtils.copyProperties(create, user, "repeatPassword");
		return userRepository.save(user);
	}

	@Override
	public Response login(@Valid LoginUser user) {

		User user2 = userRepository.findUserByUserName(user.getUsername());
		if (user2 == null) {
			throw new UserNotFoundException("User with username: " + user.getUsername() + " dose not exists");
		}
		if(Objects.equals(user2.getStatus(), LOGGED_IN)) {
			return new Response("User Already Logged In");
		}
		if (!Objects.equals(user.getPassword(), user2.getPassword())) {
			throw new PasswordDoseNotMatch("Password dose not match");
		}
		user2.setStatus(LOGGED_IN);
		userRepository.save(user2);
		return new Response("Logged in successfully");
	}

	@Override
	public Response logout(@Valid String user) {
		User user2 = userRepository.findUserByUserName(user);
		if (user2 == null) {
			throw new UserNotFoundException("User with username: " + user + " dose not exists");
		}
		user2.setStatus(LOGGED_OUT);
		userRepository.save(user2);
		return new Response("Logged out successfully");
	}

}
