package application;

import utilities.DateTime;

public class Car {
	private String regNo, make, model, driverName, availability;
	private int passengerCapacity;
	private boolean available;
	private Booking[] currentBookings, pastBooking;
	
	public Car(String regNo, String make, String model, String driverName, int passengerCapacity) 
	{
		this.regNo = regNo;
		this.make = make;
		this.model = model;
		this.driverName = driverName;
		this.passengerCapacity = passengerCapacity;	
		this.available = true;
		this.currentBookings = new Booking [5];
		this.pastBooking = new Booking [10];
		
	}
	
	public boolean book(String firstName, String lastName, DateTime required, int numPassengers) {
		Booking book1 = new Booking(firstName, lastName, required,  numPassengers, this);
		this.currentBookings[1] = book1;
		return false;
	}
	
	public boolean completeBooking(String regOrDate) {
		return false;
	}
	
	public String getDetails() {
	    if (available){
	        availability = "Yes";
        } else {
	        availability = "No";
        }
		return String.format("%-17s %s\n", "RegNo: ", regNo) + 
				String.format("%-17s %s\n", "Make & Model: ", make) + 
				String.format("%-17s %s\n", "Driver Name: ",  model) + 
				String.format("%-17s %s\n", "Capacity: ", passengerCapacity) +
				String.format("%-17s %s\n", "Available: ", availability);
		
	}
	
	public String toString() {
		return regNo+":"+make+":"+model+":"+driverName+":"+passengerCapacity+":"+available;
	}
}
