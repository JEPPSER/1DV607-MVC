package com.jesper.mvc.view;

import java.util.Scanner;

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
	public String getInput(String str){
		System.out.println(str);
		String input = "";
		
		while ((input = scan.nextLine()).isEmpty()) {
			System.out.print("Input was empty, please enter " + str);
		}
		
		return input;
	}
	
	/**
	 * Retrieves an integer from user input. 
	 * 
	 * @return Integer - Integer retrieved from user input.
	 */
	public int getInputNumber(String str) {
		System.out.println(str);
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
	 * Retrieves an double from user input. 
	 * 
	 * @return Double - Double retrieved from user input.
	 */
	public double getInputDouble(String str) {
		System.out.println(str);
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
	public String displayCommands(){
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
		return result;
	}	
}
