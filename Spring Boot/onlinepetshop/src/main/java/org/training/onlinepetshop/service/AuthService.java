package org.training.onlinepetshop.service;

import javax.validation.Valid;

import org.training.onlinepetshop.dto.LoginUser;
import org.training.onlinepetshop.dto.Response;
import org.training.onlinepetshop.dto.UserCreate;
import org.training.onlinepetshop.entity.User;

public interface AuthService {
	
	User register(UserCreate create);

	Response login(@Valid LoginUser user);

	Response logout(@Valid String user);

}
