package com.airline.flightbooking.service;

import com.airline.flightbooking.exception.InvalidEmailException;
import com.airline.flightbooking.exception.InvalidPnrException;
import com.airline.flightbooking.model.FlightBook;
import com.airline.flightbooking.model.FlightBookSinglePassenger;
import com.airline.flightbooking.model.Flight;
import com.airline.flightbooking.model.PassengerDetails;
import com.airline.flightbooking.model.StorePassenger;
import com.airline.flightbooking.repository.SinglePassengerRepository;
import com.airline.flightbooking.repository.StorePassengerRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookFlightService {
	@Autowired
	private SinglePassengerRepository singlePassengerRepository;

	public FlightBookSinglePassenger bookFlight(FlightBookSinglePassenger b) {
		int pnr1;
		while (true) {
			int pnr = (int) UUID.randomUUID().getLeastSignificantBits();
			if (pnr > 0) {
				pnr1 = pnr;
				break;
			}
		}
		b.setPnr(pnr1);
		return singlePassengerRepository.save(b);
	}

	public FlightBookSinglePassenger[] getbookingdetails(long pnr) throws InvalidPnrException {

		// return singlePassengerRepository.findByPnr(pnr);

		FlightBookSinglePassenger[] passengerdetails = singlePassengerRepository.findByPnr(pnr);

		if (0 != passengerdetails.length) {
			return passengerdetails;
		} else

		{
			throw new InvalidPnrException("Invalid PNR");
		}

	}

	public FlightBookSinglePassenger[] getbookingdetailsmail(String mail) throws InvalidEmailException {
		FlightBookSinglePassenger[] passengerdetails = singlePassengerRepository.findByEmail(mail);
		if (0 != passengerdetails.length) {
			return passengerdetails;
		} else

		{
			throw new InvalidEmailException("Invalid Email");
		}
	}

	public void cancelTicket(int id) {
		singlePassengerRepository.deleteById(id);
	}

}
