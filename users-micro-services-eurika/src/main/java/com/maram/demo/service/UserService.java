package com.maram.demo.service;


import java.util.*;

import com.maram.demo.entities.Role;
import com.maram.demo.entities.User;
import com.maram.demo.service.exceptions.EmailAlreadyExistsException;
import com.maram.demo.service.register.RegistrationRequest;


public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
	List<User> findAllUsers();
	User registerUser(RegistrationRequest request);
	
	public User validateToken(String code);
	
}	