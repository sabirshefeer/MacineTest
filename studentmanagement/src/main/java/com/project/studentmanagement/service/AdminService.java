package com.project.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.studentmanagement.model.Users;
import com.project.studentmanagement.reopositeries.UserRepository;

@Service
public class AdminService {

	@Autowired
	UserRepository userRepository;

	public Users getUserDetails(Users user) {
		Users userFromDb = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

		return userFromDb;
	}

	public Users saveAdmin(Users user) {
		return userRepository.save(user);
	}

}
