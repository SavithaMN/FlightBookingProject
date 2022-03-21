package com.airline.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.airline.flightbooking.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	List<Flight> findByFromPlaceAndToPlace(String fromplace, String toplace);
}
