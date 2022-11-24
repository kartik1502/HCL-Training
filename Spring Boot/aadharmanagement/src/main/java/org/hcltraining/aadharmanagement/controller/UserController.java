package org.hcltraining.aadharmanagement.controller;

import java.util.List;

import org.hcltraining.aadharmanagement.entity.User;
import org.hcltraining.aadharmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUser(){
    	return userService.getAllUser();
    }
    
    @PutMapping("/updateUser")
    public User updateUser(String firstName, User user) {
    	return userService.updateUser(firstName ,user);
    }
   
}
