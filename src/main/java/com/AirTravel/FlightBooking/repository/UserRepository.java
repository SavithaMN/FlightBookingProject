package com.AirTravel.FlightBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AirTravel.FlightBooking.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	}



