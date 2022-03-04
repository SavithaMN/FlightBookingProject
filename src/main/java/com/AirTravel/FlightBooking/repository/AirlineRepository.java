package com.AirTravel.FlightBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AirTravel.FlightBooking.model.Airline;

public interface AirlineRepository extends JpaRepository<Airline, Integer>{

}
