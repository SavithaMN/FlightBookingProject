package com.airline.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.airline.flightbooking.model.Airline;

@Repository
/* @Component("airlinerepository") */
public interface AirlineRepository extends JpaRepository<Airline, Integer> {

}
