package com.AirTravel.FlightBooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AirTravel.FlightBooking.model.Airline;
import com.AirTravel.FlightBooking.model.FlightDetails;
import com.AirTravel.FlightBooking.repository.AirlineRepository;
import com.AirTravel.FlightBooking.repository.FlightRepository;

@Service
public class FlightService {
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private AirlineRepository AirlineRespository;

	public FlightDetails saveFlight(FlightDetails b) {

		return flightRepository.save(b);

	}

	public List<FlightDetails> getAllFlight() {
		List<FlightDetails> listofflights = flightRepository.findAll();
		List<FlightDetails> resultlist = new ArrayList<FlightDetails>();
		for (FlightDetails flightDetails : listofflights) {
			int airlineid = flightDetails.getAirlineId();

			Optional<Airline> airlinedetails = AirlineRespository.findById(airlineid);
			if (airlinedetails.isPresent()) {

				if (!airlinedetails.get().getIsblocked())
					resultlist.add(flightDetails);
			}

		}
		return resultlist;
	}

	public FlightDetails updateFlight(FlightDetails b) {
		if (flightRepository.existsById(b.getFlightNumber())) {
			return flightRepository.save(b); // save if id not found, edit where id is found
		} else {
			throw new RuntimeException("Invalid flight id, update operation failed");
		}
	}

	public boolean deleteFlight(String FlightNumber) {
		boolean isFound = flightRepository.existsById(FlightNumber);
		flightRepository.deleteById(FlightNumber);
		return isFound;
	}

	public List<FlightDetails> flightsByCriteria(String fromPlace, String toPlace) {

		return flightRepository.findByFromPlaceAndToPlace(fromPlace, toPlace);
	}

	/*
	 * public List<FlightDetails> flightsByCriteria(String from,String to){ return
	 * flightRepository.getFlightsBasedOnCriteria(from, to); }
	 */

}
