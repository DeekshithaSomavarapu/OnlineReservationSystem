package com.example.reservationsystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservationSystem {
	private List<User> users;
	private List<Reservation> reservations;
	
	public ReservationSystem() {
		users = new ArrayList<>();
		reservations = new ArrayList<>();
	}
	
	public void registerUser (String username, String password) {
		users.add(new User(username, password));
		System.out.println("User registered successfully!");
	}
	
	public User loginUser (String username, String password) {
		for(User user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
	public void makeReservation(String username, LocalDateTime dateTime, String service) {
		reservations.add(new Reservation(username, dateTime, service));
		System.out.println("Reservation made successfully!");
	}
	
	public void viewReservations(String username) {
		System.out.println("Reservations for " + username + ";");
		for(Reservation reservation : reservations) {
			if(reservation.getUsername().equals(username)) {
				System.out.println(reservation);
			}
		}
	}
}