package com.jesper.mvc.view;

import java.util.Scanner;

import com.jesper.mvc.controller.Actions;

/**
 * Class that prints information for the user
 * to the console.
 * 
 * @name ConsoleView.java
 * @version 0.00.00
 */
public class ConsoleView {
	
	private Scanner scan = new Scanner(System.in);
	
	/**
	 * Retrieved user input. 
	 * 
	 * @return String - String of user input.
	 */
	public String getInput(){
		String input = "";
		
		while ((input = scan.nextLine()).isEmpty());
		
		return input;
	}
	
	/**
	 * Retrieves an integer from user input. 
	 * 
	 * @return Integer - Integer retrieved from user input.
	 */
	public int getInputNumber() {
		int input;
		
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.print("Input was not a valid number. Please enter a number: ");
		}
		
		input = scan.nextInt();
		scan.nextLine();
		return input;
	}
	
	/**
	 * Retrieves a user action from input.
	 * 
	 * @return - Action depending on input.
	 */
	public Actions getAction() {
		int input;
		
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.print("Input was not a valid number. Please enter a number: ");
		}
		
		input = scan.nextInt();
		scan.nextLine();
		
		switch (input) {
		case 1:
			return Actions.VIEW_ALL_MEMBERS;
		case 2:
			return Actions.VIEW_ALL_MEMBERS_VERBOSE;
		case 3: 
			return Actions.CREATE_MEMBER;
		case 4:
			return Actions.UPDATE_MEMBER;
		case 5:
			return Actions.DELETE_MEMBER;
		case 6:
			return Actions.VIEW_MEMBER;
		case 7:
			return Actions.CREATE_BOAT;
		case 8:
			return Actions.UPDATE_BOAT;
		case 9:
			return Actions.DELETE_BOAT;
		case 10:
			return Actions.VIEW_BOAT;
		case 11:
			return Actions.QUIT;
		default:
			return Actions.NOACTION;
		}
	}
	
	/**
	 * Retrieves an double from user input. 
	 * 
	 * @return Double - Double retrieved from user input.
	 */
	public double getInputDouble() {
		double input;
		
		while (!scan.hasNextDouble()) {
			scan.next();
			System.out.print("Input was not a valid number. Please enter a number: ");
		}
		
		input = scan.nextDouble();
		scan.nextLine();
		return input;
	}
	
	/**
	 * Displays all available commands for the user.
	 */
	public void displayCommands(){
		String result = "1. View All Members\n"
				+ "2. View All Members Verbose\n"
				+ "3. Create Member\n"
				+ "4. Update Member\n"
				+ "5. Delete Member\n"
				+ "6. View Member\n"
				+ "7. Create Boat\n"
				+ "8. Update Boat\n"
				+ "9. Delete Boat\n"
				+ "10. View Boat\n"
				+ "11. Quit";
		
		System.out.println(result);
	}
	
	/**
	 * Displays a message that invalid input has been recieved.
	 */
	public void displayInvalidInput() {
		System.out.println("Invalid input, please try again.");
	}
	
	/**
	 * Displays prompt asking for a name input.
	 */
	public void displayName() {
		System.out.println("Name: ");
	}
	
	/**
	 * Displays a prompt asking for a personal number input.
	 */
	public void displayPersonalNumber() {
		System.out.println("Personal Number: ");
	}
	
	/**
	 * Displays a prompt asking for a member id input.
	 */
	public void displayMemberId() {
		System.out.println("Member id: ");
	}
	
	/**
	 * Displays a prompt asking for a boat number input.
	 */
	public void displayBoatNumber() {
		System.out.println("Boat Number: ");
	}
	
	/**
	 * Displays a prompt asking for a boat length input.
	 */
	public void displayBoatLength() {
		System.out.println("Boat Length: ");
	}
	
	/**
	 * Displays a prompt asking for a boat type input.
	 */
	public void displayBoatType() {
		System.out.println("Boat Type(Sailboat, Motorsailer, Canoe, Other): ");
	}
}
