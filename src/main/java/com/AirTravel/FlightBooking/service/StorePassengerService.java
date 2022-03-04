package com.AirTravel.FlightBooking.service;

import com.AirTravel.FlightBooking.model.FlightBook;
import com.AirTravel.FlightBooking.model.FlightDetails;
import com.AirTravel.FlightBooking.model.PassengerDetails;
import com.AirTravel.FlightBooking.model.StorePassenger;
import com.AirTravel.FlightBooking.repository.StorePassengerRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

			StorePassenger passengerDetails = new StorePassenger(p[i].getName(), p[i].getGender(),
					p[i].getAge(), seatnumbers[i], p[i].getMeal(), pnr1, email, flightid);
			storePassengerDetailsRepository.save(passengerDetails);
		}
		String s = "Flight has been booked successfully and your pnr number is: " + pnr1;

		return s;

	}

	public StorePassenger[] getbookingdetails(long pnr) {
		return storePassengerDetailsRepository.findByPnr(pnr);

	}

	public StorePassenger[] getbookingdetailsmail(String mail) {
		return storePassengerDetailsRepository.findByEmail(mail);
	}

}
