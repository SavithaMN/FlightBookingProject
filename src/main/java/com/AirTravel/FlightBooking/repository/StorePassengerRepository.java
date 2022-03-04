package com.AirTravel.FlightBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AirTravel.FlightBooking.model.StorePassenger;

public interface StorePassengerRepository extends JpaRepository<StorePassenger, Integer>{
	
	StorePassenger[] findByPnr(long pnr);
	StorePassenger[] findByEmail(String email);

}
