package com.AirTravel.FlightBooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.AirTravel.FlightBooking.model.FlightDetails;

public interface FlightRepository extends JpaRepository<FlightDetails, String> {

	List<FlightDetails> findByFromPlaceAndToPlace(String fromplace, String toplace);
}
