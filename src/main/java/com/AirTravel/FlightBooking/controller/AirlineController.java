package com.AirTravel.FlightBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AirTravel.FlightBooking.model.Airline;
import com.AirTravel.FlightBooking.model.FlightDetails;
import com.AirTravel.FlightBooking.service.AirlineService;

@RestController
@RequestMapping("/airline")
public class AirlineController {

	@Autowired
	AirlineService airlineService;

	@GetMapping("/getAllAirlines")
	public List<Airline> getAll() {
		return airlineService.getAll();
	}

	@PostMapping("/add")
	public List<Airline> save(@RequestBody List<Airline> details) {
		return airlineService.save(details);
	}

	@GetMapping("/block/{airline_id}")
	public String blockId(@PathVariable int airline_id) {
		return airlineService.blockID(airline_id);
	}

}
