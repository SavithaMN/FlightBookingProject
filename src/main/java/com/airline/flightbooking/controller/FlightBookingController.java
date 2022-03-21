package com.airline.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.flightbooking.exception.InvalidEmailException;
import com.airline.flightbooking.exception.InvalidPnrException;
import com.airline.flightbooking.model.FlightBook;
import com.airline.flightbooking.model.FlightBookSinglePassenger;
import com.airline.flightbooking.model.StorePassenger;
import com.airline.flightbooking.service.BookFlightService;
import com.airline.flightbooking.service.StorePassengerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/airline/flight")
public class FlightBookingController {
	@Autowired
	private BookFlightService bookFlightService;

	@PostMapping("/booking/{flightid}")
	public FlightBookSinglePassenger bookflight(@RequestBody FlightBookSinglePassenger b,
			@PathVariable String flightid) {
		b.setFlightnumber(flightid);
		return bookFlightService.bookFlight(b);
	}

	@GetMapping("/ticket/{pnr}")
	public FlightBookSinglePassenger[] getflight(@PathVariable long pnr) throws InvalidPnrException {
		return bookFlightService.getbookingdetails(pnr);

	}

	@GetMapping("/booking/history/{emailId}")
	public FlightBookSinglePassenger[] getemailtofilter(@PathVariable String emailId) throws InvalidEmailException {

		return bookFlightService.getbookingdetailsmail(emailId);
	}

	@DeleteMapping("/cancel/ticket/{id}")
	public void cancelTicket(@PathVariable int id) {
		bookFlightService.cancelTicket(id);

	}

}
