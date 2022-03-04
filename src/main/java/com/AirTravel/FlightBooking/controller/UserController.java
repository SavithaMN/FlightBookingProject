package com.AirTravel.FlightBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AirTravel.FlightBooking.model.User;
import com.AirTravel.FlightBooking.service.UserService;

@RestController
@RequestMapping("/UserRegisteration")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public String UserRegistered(@RequestBody User user) {
		userService.saveBook(user);
		return "registered successfully";
	}

	@GetMapping("/")
	public List<User> users() {
		return userService.getallusers();
	}

	@PutMapping("/")
	public User updateUser(@RequestBody User ud) {
		return userService.updateBook(ud);
	}

	@DeleteMapping("/{Name}")
	public boolean updateUser(@PathVariable String Name) {
		return userService.deleteUser(Name);
	}

}
