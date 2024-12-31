package com.example.reservationsystem;

import java.time.LocalDateTime;

public class Reservation {
	private String username;
	private LocalDateTime dateTime;
	private String service;
	
	public Reservation(String username, LocalDateTime dateTime, String service) {
		this.username = username;
		this.dateTime = dateTime;
		this.service = service;
	}
	
	public String getUsername() {
		return username;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public String getService() {
		return service;
	}
	
	@Override
	public String toString() {
		return "Reservation{" +
				"username='" + username + '\'' +
				", dateTime=" + dateTime +
				", sevice='" + service + '\'' +
				'}';
		
	}

}
 