package org.hcltraining.aadharmanagement.service;

import java.util.List;

import org.hcltraining.aadharmanagement.entity.User;

public interface UserService {

    User addUser(User user);

	List<User> getAllUser();

	User updateUser(String firstName, User user);
}
