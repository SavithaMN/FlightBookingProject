package com.AirTravel.FlightBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AirTravel.FlightBooking.model.FlightDetails;
import com.AirTravel.FlightBooking.service.FlightService;

@RestController
@RequestMapping("/flight/airline/inventory")
public class FlightController {

	@Autowired
	private FlightService flightService;

	@PostMapping("/add")
	public String addFlight(@RequestBody List<FlightDetails> ud) {
		for (FlightDetails flightDetails : ud) {
			flightService.saveFlight(flightDetails);
		}

		return "Data Added successfully";
	}

	@GetMapping("/getflights")
	public List<FlightDetails> getAllRegisteredflights() {
		return flightService.getAllFlight();
	}

	@PutMapping("/updateflights")
	public String updateflight(@RequestBody List<FlightDetails> ud) {
		for (FlightDetails flightDetails : ud) {
			flightService.updateFlight(flightDetails);
		}

		return "updated successfully";
	}

	@DeleteMapping("/deleteflights/{flightId}")
	public boolean updateflight(@PathVariable String flightId) {
		return flightService.deleteFlight(flightId);
	}

	@GetMapping("/searchCriteria/{fromPlace}/{toPlace}")
	public List<FlightDetails> searchCriteria(@PathVariable String fromPlace, @PathVariable String toPlace) {
		return flightService.flightsByCriteria(fromPlace, toPlace);
	}

}
