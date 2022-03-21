package com.airline.flightbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.airline.flightbooking.model.User;
import com.airline.flightbooking.repository.UserRepository;

@org.springframework.stereotype.Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveBook(User r) {

		return userRepository.save(r);
	}

	public List<User> getallusers() {
		return userRepository.findAll();
	}

	public User updateBook(User b) {
		if (userRepository.existsById(b.getName())) {
			return userRepository.save(b); // save if id not found, edit where id is found
		} else {
			throw new RuntimeException("Invalid id, update operation failed");
		}
	}

	public boolean deleteUser(String Name) {
		boolean isFound = userRepository.existsById(Name);
		userRepository.deleteById(Name);
		return isFound;
	}

}
