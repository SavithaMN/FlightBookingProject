package com.airline.flightbooking.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.flightbooking.exception.InvalidAirlineIdException;
import com.airline.flightbooking.model.Flight;
import com.airline.flightbooking.service.FlightService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/flight/airline/inventory")
public class FlightController {

	@Autowired
	private FlightService flightService;

	@PostMapping("/add")
	public int addFlight(@RequestBody Flight ud) throws InvalidAirlineIdException {
		System.out.println(ud.getNumber());

		return flightService.saveFlight(ud).getNumber();

	}

	@GetMapping("/getflights")
	public List<Flight> getAllRegisteredflights() {
		return flightService.getAllFlight();
	}

	@DeleteMapping("/deleteflights/{flightId}")
	public boolean updateflight(@PathVariable int flightId) {
		return flightService.deleteFlight(flightId);
	}

	@GetMapping("/searchCriteria/{fromPlace}/{toPlace}")
	public List<Flight> searchCriteria(@PathVariable String fromPlace, @PathVariable String toPlace) {
		return flightService.flightsByCriteria(fromPlace, toPlace);
	}

	@GetMapping("/searchCriteria/{fromPlace}/{toPlace}/{startdate}")
	public List<Flight> searchCriteriawithStartdate(@PathVariable String fromPlace, @PathVariable String toPlace,
			@PathVariable String startdate) {
		LocalDateTime date = LocalDateTime.parse(startdate);
		return flightService.flightsByCriteriabystartdate(fromPlace, toPlace, date);
	}

	@GetMapping("/returnflight/{fromPlace}/{toPlace}/{returndate}")
	public List<Flight> searchCriteriawithreturndate(@PathVariable String fromPlace, @PathVariable String toPlace,
			@PathVariable String returndate) {
		LocalDateTime date = LocalDateTime.parse(returndate);
		return flightService.flightsByCriteriabyreturndate(fromPlace, toPlace, date);
	}

}
