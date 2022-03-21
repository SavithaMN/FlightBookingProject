package com.airline.flightbooking.model;

import java.time.LocalDateTime;

public class ErrorMessage {
	private String msg;
	private LocalDateTime time;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public ErrorMessage(String msg, LocalDateTime time) {
		super();
		this.msg = msg;
		this.time = time;
	}

	public ErrorMessage() {
	}

}
