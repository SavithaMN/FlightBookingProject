package com.airline.flightbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.flightbooking.model.StorePassenger;

public interface StorePassengerRepository extends JpaRepository<StorePassenger, Integer> {

	StorePassenger[] findByPnr(long pnr);

	StorePassenger[] findByEmail(String email);

}
