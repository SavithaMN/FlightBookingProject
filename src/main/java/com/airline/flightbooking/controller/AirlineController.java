package com.airline.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.flightbooking.exception.InvalidAirlineIdException;
import com.airline.flightbooking.model.Airline;
import com.airline.flightbooking.service.AirlineService;

@CrossOrigin(origins = "http://localhost:4200/")
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
	public int save(@RequestBody Airline details) {
		return airlineService.save(details).getNumber();
	}

	@GetMapping("/block/{airline_id}")
	public void blockId(@PathVariable int airline_id) throws InvalidAirlineIdException {
		airlineService.blockID(airline_id);
	}

	@GetMapping("/unblock/{airline_id}")
	public void unBlockId(@PathVariable int airline_id) throws InvalidAirlineIdException {
		airlineService.unBlockID(airline_id);
	}

	@DeleteMapping("/delete/{airline_id}")
	public void deleteId(@PathVariable int airline_id) throws InvalidAirlineIdException {
		airlineService.deleteID(airline_id);
	}

}
