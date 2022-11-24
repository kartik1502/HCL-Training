package org.hcltraining.aadharmanagement.service.implementation;

import java.util.List;

import org.hcltraining.aadharmanagement.entity.User;
import org.hcltraining.aadharmanagement.repository.UserRepository;
import org.hcltraining.aadharmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(String firstName, User user) {
		User user2 = userRepository.findUserByFirstName(firstName);
		if(user.getFirstName() != null)
			user2.setFirstName(user.getFirstName());
		if(user2.getLastName() != null)
			user2.setLastName(user.getLastName());
		if(user2.getEmailId() != null)
			user2.setEmailId(user.getEmailId());
		return userRepository.save(user2);
	}
}
