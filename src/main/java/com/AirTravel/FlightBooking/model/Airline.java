package com.AirTravel.FlightBooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airline {
	@Id
	private int airlineNumber;

	@Column(nullable = false)
	private String airlineName;
	@Column(nullable = false)
	private boolean isblocked;

	public Airline() {
	}

	public Airline(int airlineNumber, String airlineName, boolean isblocked) {
		this.airlineNumber = airlineNumber;
		this.airlineName = airlineName;
		this.isblocked = isblocked;
	}

	public int getAirlineNumber() {
		return airlineNumber;
	}

	public void setAirlineNumber(int airlineNumber) {
		this.airlineNumber = airlineNumber;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public boolean getIsblocked() {
		return isblocked;
	}

	public void setIsblocked(boolean isblocked) {
		this.isblocked = isblocked;
	}

}
