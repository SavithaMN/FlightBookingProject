package com.airline.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.flightbooking.exception.InvalidPnrException;
import com.airline.flightbooking.model.FlightBook;
import com.airline.flightbooking.model.StorePassenger;
import com.airline.flightbooking.service.StorePassengerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/flight")
public class BookingInfoController {
	@Autowired
	private StorePassengerService bookinginfoservice;

	@PostMapping("/booking/{flightid}")
	public String bookflight(@RequestBody FlightBook b, @PathVariable String flightid) {
		b.setFlightid(flightid);
		return bookinginfoservice.saveFlight(b);
	}

	@GetMapping("/ticket/{pnr}")
	public StorePassenger[] getflight(@PathVariable long pnr) throws InvalidPnrException {
		return bookinginfoservice.getbookingdetails(pnr);

	}

	@GetMapping("/booking/history/{emailId}")
	public StorePassenger[] getemailtofilter(@PathVariable String emailId) {

		return bookinginfoservice.getbookingdetailsmail(emailId);
	}

}
