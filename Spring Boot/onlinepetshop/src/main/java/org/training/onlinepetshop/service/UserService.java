package org.training.onlinepetshop.service;

import org.training.onlinepetshop.entity.User;

public interface UserService {

	User findUserByUserName(String username);

}
 