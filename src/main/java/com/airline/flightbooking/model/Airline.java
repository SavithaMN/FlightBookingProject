package com.airline.flightbooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airline {
	@Id
	private int number;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private boolean isblocked;

	public Airline() {
	}

	public Airline(int number, String name, boolean isblocked) {
		this.number = number;
		this.name = name;
		this.isblocked = isblocked;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsblocked() {
		return isblocked;
	}

	public void setIsblocked(boolean isblocked) {
		this.isblocked = isblocked;
	}

	/*
	 * @Override public String toString() { return "Airline [number=" + number +
	 * ", name=" + name + ", isblocked=" + isblocked +"]"; }
	 */

}
