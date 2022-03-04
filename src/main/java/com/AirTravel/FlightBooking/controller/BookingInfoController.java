package com.AirTravel.FlightBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AirTravel.FlightBooking.model.FlightBook;
import com.AirTravel.FlightBooking.model.StorePassenger;
import com.AirTravel.FlightBooking.service.StorePassengerService;

@RestController
@RequestMapping("/flight")
public class BookingInfoController {
	@Autowired
	private StorePassengerService bookinginfoservice;

//need to remove  /api/v1.0/ from all the url
	@PostMapping("/booking/{flightid}")
	public String bookflight(@RequestBody FlightBook b, @PathVariable String flightid) {
		b.setFlightid(flightid);
		return bookinginfoservice.saveFlight(b);
	}

	@GetMapping("/ticket/{pnr}")
	public StorePassenger[] getflight(@PathVariable long pnr) {

		return bookinginfoservice.getbookingdetails(pnr);
	}

	@GetMapping("/booking/history/{emailId}")
	public StorePassenger[] getemailtofilter(@PathVariable String emailId) {

		return bookinginfoservice.getbookingdetailsmail(emailId);
	}

}
