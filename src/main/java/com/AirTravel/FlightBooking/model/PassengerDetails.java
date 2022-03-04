package com.AirTravel.FlightBooking.model;

import java.io.Serializable;

public class PassengerDetails implements Serializable {
	private String name;
	private String gender;
	private int age;
	private String meal;
	 
	
	public PassengerDetails(String name, String gender, int age, String meal) {
		
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.meal = meal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	
	
}

