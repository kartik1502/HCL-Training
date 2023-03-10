package org.training.springsecurity.service.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.training.springsecurity.dto.ResponseDto;
import org.training.springsecurity.dto.UserDto;
import org.training.springsecurity.entity.Role;
import org.training.springsecurity.entity.User;
import org.training.springsecurity.exception.NoSuchUserExists;
import org.training.springsecurity.exception.UserAlreadyExists;
import org.training.springsecurity.repository.UserRepository;
import org.training.springsecurity.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = repository.findByUserEmailId(username);
		if(user.isEmpty()) {
			throw new NoSuchUserExists("User with user name: "+username+" dose not exists");
		}
		return new org.springframework.security.core.userdetails.User(user.get().getUserEmailId(), user.get().getUserPassword(), getAuthority(user.get()));
	}
	
	private List<SimpleGrantedAuthority> getAuthority(User user ){
		return Arrays.asList(new SimpleGrantedAuthority(user.getRole().name()));
	}

	@Override
	public ResponseDto addUser(UserDto userDto) {
		
		if(repository.findByUserEmailId(userDto.getUserEmailId()).isPresent()) {
			throw new UserAlreadyExists("User with user name: "+userDto.getUserEmailId()+" already exists");
		}
		User user = new User();
		BeanUtils.copyProperties(userDto, user , "repeatPassword");
		if(userDto.getRole().equalsIgnoreCase("admin")) {
			user.setRole(Role.ADMIN);
		}
		else {
			user.setRole(Role.USER);
		}
		user.setUserPassword(passwordEncoder.encode(userDto.getPassword()));
		repository.save(user);
		return new ResponseDto(200, Set.of("User registerd successfully"));
		
	}

	@Override
	public User findByusername(String userName) {
		return repository.findByUserEmailId(userName).get();
	}

	@Override
	public List<User> getAll() {
		return repository.findAll();
	}
	
	

}
