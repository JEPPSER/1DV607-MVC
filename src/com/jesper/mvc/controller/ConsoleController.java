package com.jesper.mvc.controller;

import java.util.Scanner;

import com.jesper.mvc.model.Boat;
import com.jesper.mvc.model.Member;
import com.jesper.mvc.persistence.Database;

/**
 * ConsoleController handles actions to take depending on the console input retrieved from the ConsoleView.
 * 
 * @author Oskar
 */
public class ConsoleController {
	
	private Database database;
	private MemberController memberController;
	private BoatController boatController;
	
	/**
	 * Default constructor for the ConsoleController that initializes all the
	 * members to default values.
	 */
	public ConsoleController(/*Controller controller*/) {
		this.database = Database.getInstance();
		this.memberController = new MemberController();
		this.boatController = new BoatController();
	}
	
	/**
	 * TODO: ConsoleView should contain all retrieving of input. This controller should just 
	 * call proper methods from ConsoleView to retrieve its input.
	 */
	public void start() {
		Scanner scan = new Scanner(System.in);
		
		int cmd = 0;
		
		while (true /*cmd = controller.getCommand()*/) {
			
			switch(cmd) {
			case 1: /* View All Members */
				{
					int total = this.database.getTotalMembers();
					for (int i = 0; i < total; i++) {
						this.memberController.view(i);
					}

					break;
				}
			case 2: /* View All Members Verbose */
				{
					int total = this.database.getTotalMembers();
					
					for (int i = 0; i < total; i++) {
						this.memberController.viewVerbose(i);
					}
					
					break;
				}
			case 3: /* Create Member */
				{
					//TODO: Get Name input and personal number input..
					
					this.memberController.create(new Member());
					break;
				}
			case 4: /* Update Member */
				{
					//TODO: input for member id and values to update to..
					
					this.memberController.update(0, new Member());
					break;
				}
			case 5: /* Delete Member */
				{
					// TODO: input for member id..
					
					this.memberController.delete(0);
					break;
				}
			case 6: /* View Member */
				{
					//TODO: Input for member id..
					this.memberController.view(0);
					break;
				}
			case 7: /* Create Boat */
				{
					//TODO: 
					// 1. Get Target member through input.
					// 3. Get New Boat info through input.
					this.database.getMember(0);
					
					this.boatController.create(new Member(), new Boat());
					break;
				}
			case 8: /* Update Boat */
				{
					//TODO:
					// 1. Get Target member through input
					// 2. Get BoatNr in member list through input.
					// 3. Get New Boat info to update old boat too..
					
					
					this.boatController.update(new Member(), new Boat(), new Boat());
					break;
				}
			case 9: /* Delete Boat */
				{
					//TODO:
					// 1. Get Member through MemberId through input
					// 2. Get BoatNr in member list through input.
					// 3. Get boat obj based on that number..
					
					
					this.boatController.delete(new Member(), new Boat());
					break;
				}
			case 10: /* View Boat */
				{
					//TODO:
					// 1. Get MemberId through input
					// 2. Get BoatNr in member list through input.
					// 3. Get boat obj based on that number..
					
					this.boatController.view(new Boat());
					break;
				}
			case 11: /* Quit application. */
				{
					this.database.save();
					return;
				}
			default:
				break;
			}
		}
	}
}
