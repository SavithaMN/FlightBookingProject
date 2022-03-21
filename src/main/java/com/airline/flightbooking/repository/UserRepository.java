package com.airline.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.flightbooking.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	// User findByFromPlaceAndToPlace(String fromplace, String toplace);

}
