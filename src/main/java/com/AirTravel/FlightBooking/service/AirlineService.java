package com.AirTravel.FlightBooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AirTravel.FlightBooking.model.Airline;
import com.AirTravel.FlightBooking.repository.AirlineRepository;

@Service
public class AirlineService {

	@Autowired
	AirlineRepository airlineRepository;

	public List<Airline> getAll() {
		return airlineRepository.findAll();
	}

	public List<Airline> save(List<Airline> airlineData) {

		return airlineRepository.saveAll(airlineData);
	}

	public String blockID(Integer airline_id) {

		Optional<Airline> mydata = airlineRepository.findById(airline_id);

		if (mydata.isPresent()) {
			mydata.get().setIsblocked(true);
			airlineRepository.save(mydata.get());
		} else {
			return "ID Invalid";
		}

		return "Successfully Blocked";

	}

}
