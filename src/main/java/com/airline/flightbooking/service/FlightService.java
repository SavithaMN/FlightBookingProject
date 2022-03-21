package com.airline.flightbooking.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.flightbooking.exception.InvalidAirlineIdException;
import com.airline.flightbooking.model.Airline;
import com.airline.flightbooking.model.Flight;
import com.airline.flightbooking.repository.AirlineRepository;
import com.airline.flightbooking.repository.FlightRepository;

@Service
public class FlightService {
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private AirlineRepository AirlineRespository;

	public Flight saveFlight(Flight b) throws InvalidAirlineIdException {

		if (AirlineRespository.existsById(b.getAirlineId()))
			return flightRepository.save(b);
		else
			throw new InvalidAirlineIdException("Airline doesn't exist");

	}

	public List<Flight> getAllFlight() {
		List<Flight> listofflights = flightRepository.findAll();
		List<Flight> resultlist = new ArrayList<Flight>();
		for (Flight flightDetails : listofflights) {
			int airlineid = flightDetails.getAirlineId();

			Optional<Airline> airlinedetails = AirlineRespository.findById(airlineid);
			if (airlinedetails.isPresent()) {

				if (!airlinedetails.get().getIsblocked())
					resultlist.add(flightDetails);
			}

		}
		return resultlist;
	}

	/*
	 * public Flight updateFlight(Flight b) { if
	 * (flightRepository.existsById(b.getFlightNumber())) { return
	 * flightRepository.save(b); // save if id not found, edit where id is found }
	 * else { throw new
	 * RuntimeException("Invalid flight id, update operation failed"); } }
	 */

	public boolean deleteFlight(int FlightNumber) {
		System.err.println("---------" + FlightNumber);
		boolean isFound = flightRepository.existsById(FlightNumber);
		flightRepository.deleteById(FlightNumber);
		return isFound;
	}

	public List<Flight> flightsByCriteria(String fromPlace, String toPlace) {

		List<Flight> listofflights = flightRepository.findByFromPlaceAndToPlace(fromPlace, toPlace);
		List<Flight> resultlist = new ArrayList<Flight>();
		for (Flight flightDetails : listofflights) {
			int airlineid = flightDetails.getAirlineId();

			Optional<Airline> airlinedetails = AirlineRespository.findById(airlineid);
			if (airlinedetails.isPresent()) {

				if (!airlinedetails.get().getIsblocked())
					resultlist.add(flightDetails);
			}

		}
		System.out.println(resultlist.get(0).getStartDateTime().isAfter(LocalDateTime.now()));
		return resultlist;
	}

	public List<Flight> flightsByCriteriabystartdate(String fromPlace, String toPlace, LocalDateTime date2) {
		/*
		 * LocalDateTime date = Instant.ofEpochMilli(date2.getTime())
		 * .atZone(ZoneId.systemDefault()) .toLocalDateTime();
		 */

		List<Flight> listofflights = flightRepository.findByFromPlaceAndToPlace(fromPlace, toPlace);

		List<Flight> resultlist = new ArrayList<Flight>();
		for (Flight flightDetails : listofflights) {
			if (flightDetails.getStartDateTime().isAfter(date2) || flightDetails.getStartDateTime().isEqual(date2)) {
				int airlineid = flightDetails.getAirlineId();
				Optional<Airline> airlinedetails = AirlineRespository.findById(airlineid);
				if (airlinedetails.isPresent()) {

					if (!airlinedetails.get().getIsblocked())
						resultlist.add(flightDetails);
				}
			}
		}
		return resultlist;
	}

	public List<Flight> flightsByCriteriabyreturndate(String fromPlace, String toPlace, LocalDateTime date) {
		System.out.println("fromplace toplace------" + fromPlace + toPlace);
		List<Flight> listofflights = flightRepository.findByFromPlaceAndToPlace(fromPlace, toPlace);
		System.out.println("flights------" + listofflights);

		List<Flight> resultlist = new ArrayList<Flight>();
		for (Flight flightDetails : listofflights) {
			System.out.println("for------");
			if (flightDetails.getStartDateTime().isAfter(date) || flightDetails.getStartDateTime().isEqual(date)) {
				System.out.println("if------");
				int airlineid = flightDetails.getAirlineId();
				Optional<Airline> airlinedetails = AirlineRespository.findById(airlineid);
				if (airlinedetails.isPresent()) {

					if (!airlinedetails.get().getIsblocked())
						resultlist.add(flightDetails);
				}
			}
		}
		return resultlist;
	}

}
