package com.AirTravel.FlightBooking;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import com.airline.flightbooking.model.Airline;
import com.airline.flightbooking.service.AirlineService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=AirlineService.class)
class FlightBookingApplicationTests {

	@Test
	void contextLoads() {
	}
	/*
	 * @Test public void shouldGiveAirlines(){ AirlineService airlineservice = new
	 * AirlineService(); List<Airline> actualResult = airlineservice.getAll();
	 * System.out.println(actualResult.toString());
	 * Assertions.assertNotNull(actualResult); }
	 */
}
