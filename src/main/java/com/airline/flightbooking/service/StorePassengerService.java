package com.airline.flightbooking.service;

import com.airline.flightbooking.exception.InvalidPnrException;
import com.airline.flightbooking.model.FlightBook;
import com.airline.flightbooking.model.Flight;
import com.airline.flightbooking.model.PassengerDetails;
import com.airline.flightbooking.model.StorePassenger;
import com.airline.flightbooking.repository.StorePassengerRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorePassengerService {
	@Autowired
	private StorePassengerRepository storePassengerDetailsRepository;

	public String saveFlight(FlightBook b) {

		String email = b.getEmailid();
		String flightid = b.getFlightid();
		int pnr1;
		while (true) {
			int pnr = (int) UUID.randomUUID().getLeastSignificantBits();
			if (pnr > 0) {
				pnr1 = pnr;
				break;
			}
		}
		int length = b.getSeatnumbers().length;
		int[] seatnumbers = b.getSeatnumbers();
		PassengerDetails[] p = b.getPassengerdetails();

		for (int i = 0; i < length; i++) {

			StorePassenger passengerDetails = new StorePassenger(p[i].getName(), p[i].getGender(), p[i].getAge(),
					seatnumbers[i], p[i].getMeal(), pnr1, email, flightid);
			storePassengerDetailsRepository.save(passengerDetails);
		}
		String s = "Flight has been booked successfully and your pnr number is: " + pnr1;

		return s;

	}

	public StorePassenger[] getbookingdetails(long pnr) throws InvalidPnrException {

		return storePassengerDetailsRepository.findByPnr(pnr);

		/*
		 * Optional<StorePassenger>[] passengerdetails =
		 * storePassengerDetailsRepository.findByPnr(pnr);
		 * 
		 * if(passengerdetails.toString().isEmpty()) { return passengerdetails;
		 * 
		 * } else
		 * 
		 * { throw new InvalidPnrException("Invalid PNR"); }
		 */

	}

	public StorePassenger[] getbookingdetailsmail(String mail) {
		return storePassengerDetailsRepository.findByEmail(mail);
	}

}
