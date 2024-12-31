package com.example.reservationsystem;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ReservationSystem reservationSystem = new ReservationSystem();
		Scanner scanner = new Scanner(System.in);
		String option;
		
		do {
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("Choose an option: ");
			option = scanner.nextLine();
			
			switch(option) {
			case "1":
				System.out.print("Enter username: ");
				String username = scanner.nextLine();
				System.out.print("Enter password: ");
				String password = scanner.nextLine();
				reservationSystem.registerUser(username, password);
				break;
				
			case "2":
				System.out.print("Enter username:");
				String loginUsername = scanner.nextLine();
				System.out.print("Enter password: ");
				String loginPassword = scanner.nextLine();
				User user = reservationSystem.loginUser(loginUsername, loginPassword);
				if(user!= null) {
					System.out.println("Login successful!");
					String reservationOption;
					do {
						System.out.println("1. Make a Reservation");
						System.out.println("2. View Reservations");
						System.out.println("3. Logout");
						System.out.println("Choose an option: ");
						reservationOption = scanner.nextLine();
						
						switch(reservationOption) {
						case "1":
							System.out.print("Enter reservation date and time (YYYY-MM-DDTHH:MM): ");
							String dateTimeInput = scanner.nextLine();
							LocalDateTime dateTime = LocalDateTime.parse(dateTimeInput);
							System.out.print("Enter service: ");
							String service = scanner.nextLine();
							reservationSystem.makeReservation(user.getUsername(), dateTime, service);
							break;
							
						case "2":
							reservationSystem.viewReservations(user.getUsername());
							break;
							
						case "3":
							System.out.println("Logging out.....");
							break;
							
							default:
								System.out.println("Invalid option. Please try again.");
						}
					}
					while(!reservationOption.equals("3"));
				} else {
					System.out.println("Invalid username or password.");
				}
				break;
				
			case "3":
				System.out.println("Exiting the application. Goodbye!");
				break;
				
				default:
					System.out.println("Invalid option. Please try again.");
			}
		} while(!option.equals("3"));
		
		scanner.close();
	
	}
}
