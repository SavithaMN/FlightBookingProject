package com.airline.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.flightbooking.exception.InvalidUserIdException;
import com.airline.flightbooking.model.Login;
import com.airline.flightbooking.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;

	@PostMapping("/")
	public String login(@RequestBody Login logindetails) throws InvalidUserIdException {
		return loginService.checkCredentials(logindetails);
	}

}
