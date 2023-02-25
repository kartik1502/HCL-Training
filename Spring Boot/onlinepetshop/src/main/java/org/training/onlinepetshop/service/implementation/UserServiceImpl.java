package org.training.onlinepetshop.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.onlinepetshop.entity.User;
import org.training.onlinepetshop.repository.UserRepository;
import org.training.onlinepetshop.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUserByUserName(String username) {
		return userRepository.findUserByUserName(username);
	}

}
