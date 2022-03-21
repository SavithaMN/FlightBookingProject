package com.airline.flightbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.flightbooking.model.FlightBookSinglePassenger;
import com.airline.flightbooking.model.StorePassenger;

public interface SinglePassengerRepository extends JpaRepository<FlightBookSinglePassenger, Integer> {

	FlightBookSinglePassenger[] findByPnr(long pnr);

	FlightBookSinglePassenger[] findByEmail(String email);

}
