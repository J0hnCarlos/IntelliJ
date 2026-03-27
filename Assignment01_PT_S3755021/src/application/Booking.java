package application;

import utilities.DateTime;

public class Booking {
	private String id;
	private double bookingFee;
	private DateTime pickUpDateTime;
	private String firstName;
	private String lastName;
	private int numPassengers;
	private double kilometersTravelled;
	private double tripFee;
	private Car car;

	String regNo, passenger, date;
	
	public Booking(String firstName, String lastName, DateTime required, int numPassengers, Car car) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pickUpDateTime = required;
		this.numPassengers = numPassengers;
		this.car = car;
	}
	
	public String getDetails(){
		return String.format("%-17s %s\n", "id: ", id) + 
				String.format("%-17s %s\n", "Booking Fee: ", bookingFee) + 
				String.format("%-17s %s\n", "Pick up Date: ",  pickUpDateTime) + 
				String.format("%-17s %s\n", "Name: ", firstName+" "+lastName) +
				String.format("%-17s %s\n", "Passengers: ", numPassengers) +
				String.format("%-17s %s\n", "Travelled: ", kilometersTravelled) +
				String.format("%-17s %s\n", "Trip Fee: ", tripFee) +
				String.format("%-17s %s\n", "Car Id: ", car);
	}

	public Booking(String regNo, String passenger, String date){
	    this.regNo = regNo;
	    this.passenger = passenger;
	    this.date = date;
    }

    public String bookDetails(){

		String msg = "";
		String dateID = "";
		String[] dateMsg;
		String[] nameArray;
		nameArray = passenger.split(" ");
		dateMsg = date.split("/");
		int i = 0;

		while (i < nameArray.length){
			msg = msg + nameArray[i].substring(0,3);
			i++;
		}

		i = 0;

		while (i < dateMsg.length){
			dateID = dateID + dateMsg[i];
			i++;
		}

		return String.format("Booking ID: " + regNo + "_" + msg + "_" + dateID);
	}
}
