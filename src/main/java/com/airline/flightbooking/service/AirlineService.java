package com.airline.flightbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.airline.flightbooking.exception.InvalidAirlineIdException;
import com.airline.flightbooking.model.Airline;
import com.airline.flightbooking.repository.AirlineRepository;

@Service
public class AirlineService {

	@Autowired
	/* @Qualifier("airlinerepository") */
	AirlineRepository airlineRepository;

	public List<Airline> getAll() {
		return airlineRepository.findAll();
	}

	public Airline save(Airline airlineData) {

		return airlineRepository.save(airlineData);
	}

	public void blockID(Integer airline_id) throws InvalidAirlineIdException {

		Optional<Airline> mydata = airlineRepository.findById(airline_id);

		if (mydata.isPresent()) {
			mydata.get().setIsblocked(true);
			airlineRepository.save(mydata.get());
		} else {
			throw new InvalidAirlineIdException("Invalid Airline ID");
		}

	}

	public void unBlockID(int airline_id) throws InvalidAirlineIdException {
		Optional<Airline> mydata = airlineRepository.findById(airline_id);

		if (mydata.isPresent()) {
			mydata.get().setIsblocked(false);
			airlineRepository.save(mydata.get());
		} else {
			throw new InvalidAirlineIdException("Invalid Airline ID");
		}

	}

	public void deleteID(int airline_id) throws InvalidAirlineIdException {
		Optional<Airline> mydata = airlineRepository.findById(airline_id);

		if (mydata.isPresent()) {
			airlineRepository.deleteById(airline_id);
		} else {
			throw new InvalidAirlineIdException("Invalid Airline ID");
		}

	}

}
