package com.airline.flightbooking.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	private int number;
	@Column(nullable = false)
	private int airlineId;
	@Column(nullable = false)
	private String fromPlace;
	@Column(nullable = false)
	private String toPlace;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private LocalDateTime startDateTime;
	@Column(nullable = false)
	private LocalDateTime endDateTime;
	@Column(nullable = false)
	private String instrumentUsed;
	@Column(nullable = false)
	private int businessClassSeatsCount;
	@Column(nullable = false)
	private int nonbusinessClassSeatsCount;

	public Flight() {

	}

	public Flight(int flightNumber, int airlineId, String fromPlace, String toPlace, double price,
			LocalDateTime startDateTime, LocalDateTime endDateTime, String instrumentUsed, int businessClassSeatsCount,
			int nonbusinessClassSeatsCount) {
		super();
		this.number = flightNumber;
		this.airlineId = airlineId;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.price = price;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.instrumentUsed = instrumentUsed;
		this.businessClassSeatsCount = businessClassSeatsCount;
		this.nonbusinessClassSeatsCount = nonbusinessClassSeatsCount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int flightNumber) {
		this.number = flightNumber;
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getInstrumentUsed() {
		return instrumentUsed;
	}

	public void setInstrumentUsed(String instrumentUsed) {
		this.instrumentUsed = instrumentUsed;
	}

	public int getBusinessClassSeatsCount() {
		return businessClassSeatsCount;
	}

	public void setBusinessClassSeatsCount(int businessClassSeatsCount) {
		this.businessClassSeatsCount = businessClassSeatsCount;
	}

	public int getNonbusinessClassSeatsCount() {
		return nonbusinessClassSeatsCount;
	}

	public void setNonbusinessClassSeatsCount(int nonbusinessClassSeatsCount) {
		this.nonbusinessClassSeatsCount = nonbusinessClassSeatsCount;
	}

}
