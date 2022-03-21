package com.airline.flightbooking.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.airline.flightbooking.exception.InvalidAirlineIdException;
import com.airline.flightbooking.exception.InvalidEmailException;
import com.airline.flightbooking.exception.InvalidPnrException;
import com.airline.flightbooking.exception.InvalidUserIdException;
import com.airline.flightbooking.model.ErrorMessage;

@ControllerAdvice
public class GloblaHandler {
	@ExceptionHandler({InvalidPnrException.class,InvalidAirlineIdException.class,InvalidUserIdException.class,InvalidEmailException.class})
	public ResponseEntity<?> handleException(Exception e){
		
		return ResponseEntity.ok().body(new ErrorMessage(e.getMessage(), LocalDateTime.now()));
	}

}
