package userinterface;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalTime;

import application.Booking;
import application.Car;

public class Menu {

	Scanner scanner = new Scanner(System.in);
	boolean isRunning;
	Car carArray[] = new Car[5];
	int carNumber = 0;
    DateFormat sdfDevice = new SimpleDateFormat("dd/mm/yyyy");

    public void runMenu() throws ParseException {
        
        String response = null;
        while(response != "")
        {
            displayMenu();
            
            while(scanner.hasNextInt())
            {
                System.out.println("No number");
                scanner.nextLine();
            }
            response = scanner.nextLine();

            selectMenuItem(response);

        }

        scanner.close();
    }


    public void displayMenu() {
    	String menuTitle = "MiRides System Menu";

        System.out.printf("***  %s " +
            "***\n\n", menuTitle);

        System.out.format("%-30s %s\n", "Create Car", "CC");
        System.out.format("%-30s %s\n", "Book Car", "BC");
        System.out.format("%-30s %s\n", "Complete Booking", "CB");
        System.out.format("%-30s %s\n", "Display ALL Cars", "DA");
        System.out.format("%-30s %s\n", "Search Specific Car", "SS");
        System.out.format("%-30s %s\n", "Search available cars", "SA");
        System.out.format("%-30s %s\n", "Seed Data", "SD");
        System.out.format("%-30s %s\n", "Exit Program", "EX");
        
        System.out.print("\nEnter selection: ");
    }

    public void selectMenuItem(String response) throws ParseException {
    	this.isRunning = true;
    	
    	while(isRunning) {
	        switch (response.toLowerCase())
	        {
	            case "cc":
	            	createCar();
	                break;
	
	            case "bc":
	                bookCar();
	                break;
	
	            case "cb":
	                // Code to be executed.
	                break;
	
	            case "da":
	                displayCar();
	                break;
	
	            case "ss":
	
	                break;
	                
	            case "sa":
	            	
	                break;
	                
	            case "sd":
	            	
	                break;
	                
	            case "ex":
	            	exit();
                    if (!isRunning){
                        System.exit(0);
                    }
	                break;
	
	            default:
	                System.out.println("Invalid selection, please try again.");
	                this.runMenu();
	                break;
	        }
        }
    }
    
    private String getUserInput() {
    	Scanner scanner = new Scanner(System.in);
    	return scanner.nextLine();
    }
    
    private void createCar() throws ParseException {
        String rego, make, model, driverName, regno, stopper;
        String[] word;
        int capacity;
        int i = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter you car regional number");
        rego = scanner.nextLine();
        while (rego.length() != 6){
            System.out.println("Rego must have 6 letters consist of alphabet for first 3 and numbers for last 3");
            this.createCar();
        }

        word = rego.split("");

        while (i < 6){
            if (word[i].matches("\\W+")){
                System.out.println("There cannot be any non alphabet letters");
                this.createCar();
            }
            i++;
        }

        char ch1 = rego.charAt(0);
        char ch2 = rego.charAt(1);
        char ch3 = rego.charAt(2);
        char ch4 = rego.charAt(3);
        char ch5 = rego.charAt(4);
        char ch6 = rego.charAt(5);

        while (Character.isDigit(ch1) || Character.isDigit(ch2) || Character.isDigit(ch3) || Character.isAlphabetic(ch4) || Character.isAlphabetic(ch5) || Character.isAlphabetic(ch6)) {
            System.out.println("Must be 3 alphabet for the first 3 letters and numbers for the last 3 digits");
            this.createCar();

            while (rego.length() != 6 || rego.matches("\\W+")){
                System.out.println("No non alphabet letters and at least 6 letters");
                this.createCar();
            }

            rego = scanner.nextLine();

            ch1 = rego.charAt(0);
            ch2 = rego.charAt(1);
            ch3 = rego.charAt(2);
            ch4 = rego.charAt(3);
            ch5 = rego.charAt(4);
            ch6 = rego.charAt(5);
        }

        regno = rego;
        System.out.println("Please enter the car's make");
        make = scanner.nextLine();

        System.out.println("Please enter the model");
        model = scanner.nextLine();

        System.out.println("Please enter the driver's name");
        driverName = scanner.nextLine();

        System.out.println("Please enter the capacity of the car");
        capacity = scanner.nextInt();

        while (capacity < 1 || capacity > 10){
            System.out.println("Capacity must be in a range of 1 - 10");
            capacity = scanner.nextInt();
        }

        carArray[carNumber] = new Car(regno, make, model, driverName, capacity);
        carNumber++;

        this.runMenu();
    }
    
    private void bookCar() throws ParseException {
        String regNo, fullname, dateTime;
        String check[] = new String[2];
        int i = 0;
        System.out.println("What is your Reg No?");
        regNo = scanner.nextLine();

        System.out.println("What is your full name?");
        fullname = scanner.nextLine();

        check = fullname.split(" ");

        i = 0;

        while (i < check.length){
                while (check[i].length() < 3) {
                    System.out.println("First and last name must have at least 3 letters");
                    fullname = scanner.nextLine();
                    check = fullname.split(" ");
                    i = 0;
            }
            i++;
        }

        System.out.println("When do you want to book the car? (dd/mm/yyyy)");
        dateTime = scanner.nextLine();

        Booking book = new Booking(regNo, fullname, dateTime);

        System.out.println(book.bookDetails());

        System.out.println("Press enter to go back to menu");
        scanner.nextLine();

        this.runMenu();

    }

    private void displayCar(){
        int i = 0;
//        int max = carNumber + 1;
//        while (i < max){
//            System.out.println(carArray[i].getDetails());
//            i++;
//        }

        System.out.println(carArray[i].getDetails());
    }
    
    private void exit() {
    	this.isRunning = false;
    }
}
