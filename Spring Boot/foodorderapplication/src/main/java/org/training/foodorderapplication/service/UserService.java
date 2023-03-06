package org.training.foodorderapplication.service;

import java.util.List;

import org.training.foodorderapplication.dto.ResponseDto;
import org.training.foodorderapplication.dto.UserDto;
import org.training.foodorderapplication.entity.User;

public interface UserService {

	ResponseDto addUser(UserDto userDto);

	User findByusername(String userName);

	List<User> getAll();

	

}
