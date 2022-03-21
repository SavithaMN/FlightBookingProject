package com.airline.flightbooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.flightbooking.exception.InvalidUserIdException;
import com.airline.flightbooking.model.Login;
import com.airline.flightbooking.model.User;
import com.airline.flightbooking.repository.AdminLoginRepository;
import com.airline.flightbooking.repository.UserRepository;

@Service
public class LoginService {
	@Autowired
	AdminLoginRepository admincredentials;
	@Autowired
	UserRepository usercredentials;

	public String checkCredentials(Login credentials) throws InvalidUserIdException {

		if (credentials.getName().contains("admin_")) {
			credentials.setName(credentials.getName().split("_")[1]);
			Optional<Login> cred = admincredentials.findById(credentials.getName());
			if (cred.isPresent()) {

				if (credentials.getPassword().equals(cred.get().getPassword())) {
					return "Admin";
				} else
					throw new InvalidUserIdException("Invalid Password");
			} else
				throw new InvalidUserIdException("Invalid UserID");
		} else {
			Optional<User> cred = usercredentials.findById(credentials.getName());
			if (cred.isPresent()) {
				if (credentials.getPassword().equals(cred.get().getPassword())) {
					return "User";
				} else
					throw new InvalidUserIdException("Invalid Password");
			} else
				throw new InvalidUserIdException("Invalid UserID");

		}

	}

}
