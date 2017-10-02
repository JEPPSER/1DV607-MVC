package com.jesper.mvc.view;

import java.util.Scanner;

/**
 * Class that prints information for the user
 * to the console.
 * 
 * @author Jesper Bergstrom
 * @name ConsoleView.java
 * @version 0.00.00
 */
public class ConsoleView {
	
	private Scanner scan = new Scanner(System.in);
	
	/**
	 * Calls start() in ConsoleController and waits for user input. 
	 * 
	 * @return String
	 */
	public String getInput(String str){
		System.out.println(str);
		String input = scan.nextLine();
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
