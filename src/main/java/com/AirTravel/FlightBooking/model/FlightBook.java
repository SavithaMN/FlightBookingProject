package com.AirTravel.FlightBooking.model;

import java.util.Arrays;

public class FlightBook {
	private String name;
	private String emailid;
	private int seats;
	private int seatnumbers[];
	private PassengerDetails passengerdetails[];
	private String flightid;

	public FlightBook() {

		// TODO Auto-generated constructor stub
	}

	public FlightBook(String name, String emailid, int seats, int seatnumbers[], PassengerDetails passengerdetails[]) {

		this.name = name;
		this.emailid = emailid;
		this.seats = seats;
		this.seatnumbers = seatnumbers;
		this.passengerdetails = passengerdetails;
	}

	public String getFlightid() {
		return flightid;
	}

	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int[] getSeatnumbers() {
		return seatnumbers;
	}

	public void setSeatnumbers(int seatnumbers[]) {
		this.seatnumbers = seatnumbers;
	}

	public PassengerDetails[] getPassengerdetails() {
		return passengerdetails;
	}

	public void setPassengerdetails(PassengerDetails[] passengerdetails) {
		this.passengerdetails = passengerdetails;
	}

	
}
