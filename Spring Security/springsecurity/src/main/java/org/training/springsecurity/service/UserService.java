package org.training.springsecurity.service;

import java.util.List;

import org.training.springsecurity.dto.ResponseDto;
import org.training.springsecurity.dto.UserDto;
import org.training.springsecurity.entity.User;

public interface UserService {

	ResponseDto addUser(UserDto userDto);

	User findByusername(String userName);

	List<User> getAll();

	

}
