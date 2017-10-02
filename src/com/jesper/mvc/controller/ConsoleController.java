package com.jesper.mvc.controller;

import com.jesper.mvc.model.Boat;
import com.jesper.mvc.model.Boat.BoatType;
import com.jesper.mvc.model.Member;
import com.jesper.mvc.persistence.Database;
import com.jesper.mvc.view.ConsoleView;

/**
 * ConsoleController handles actions to take depending on the console input retrieved from the ConsoleView.
 * 
 * @author Oskar
 */
public class ConsoleController {
	
	private Database database;
	private MemberController memberController;
	private BoatController boatController;
	private ConsoleView console;
	
	/**
	 * Default constructor for the ConsoleController that initializes all the
	 * members to default values.
	 */
	public ConsoleController(ConsoleView console) {
		this.console = console;
		this.database = Database.getInstance();
		this.memberController = new MemberController();
		this.boatController = new BoatController();
	}
	
	/**
	 * TODO: ConsoleView should contain all retrieving of input. This controller should just 
	 * call proper methods from ConsoleView to retrieve its input.
	 */
	public void start() {
		while (true) {
			
			// get input
			int cmd = Integer.parseInt(console.getInput(console.displayCommands()));
			
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
					Member member = new Member();
					member.setName(console.getInput("Name: "));
					member.setPersonalNumber(Integer.parseInt(console.getInput("Personal Number: ")));
					this.memberController.create(member);
					break;
				}
			case 4: /* Update Member */
				{
					int memId = Integer.parseInt(console.getInput("Member id: "));
					
					Member newMember = new Member();
					newMember.setName(console.getInput("New Name: "));
					newMember.setPersonalNumber(Integer.parseInt(console.getInput("New Personal Number: ")));
					
					this.memberController.update(memId, newMember);
					break;
				}
			case 5: /* Delete Member */
				{
					int memId = Integer.parseInt(console.getInput("Member id: "));
					
					this.memberController.delete(memId);
					break;
				}
			case 6: /* View Member */
				{
					int memId = Integer.parseInt(console.getInput("Member id: "));
					
					this.memberController.view(memId);
					break;
				}
			case 7: /* Create Boat */
				{
					int memId = Integer.parseInt(console.getInput("Member id: "));
					Member member = this.database.getMember(memId);
					
					double length = Double.parseDouble(console.getInput("Boat Length: "));
					BoatType boatType = null;
					String type = console.getInput("Boat Type(Sailboat, Motorsailer, Canoe, Other): ");
					type.toLowerCase();
					
					if (type.equalsIgnoreCase("Sailboat")) {
						boatType = BoatType.Sailboat;
					} else if (type.equalsIgnoreCase("Motorsailer")) {
						boatType = BoatType.Motorsailer;
					} else if (type.equalsIgnoreCase("Canoe")) {
						boatType = BoatType.Canoe;
					} else if (type.equalsIgnoreCase("Other")) {
						boatType = BoatType.Other;
					} else {
						throw new IllegalStateException("Unsupported boat type.");
					}
					
					Boat boat = new Boat();
					boat.setLength(length);
					boat.setType(boatType);
					
					this.boatController.create(member, boat);
					break;
				}
			case 8: /* Update Boat */
				{
					int memId = Integer.parseInt(console.getInput("Member id: "));
					Member member = database.getMember(memId);
					
					Boat oldBoat = member.getBoats().get(Integer.parseInt(console.getInput("Boat Number: ")));
					Boat newBoat = new Boat();
					newBoat.setLength(Double.parseDouble(console.getInput("New Length: ")));
					
					BoatType boatType = null;
					String type = console.getInput("Boat Type(Sailboat, Motorsailer, Canoe, Other): ");
					type.toLowerCase();
					
					if (type.equalsIgnoreCase("Sailboat")) {
						boatType = BoatType.Sailboat;
					} else if (type.equalsIgnoreCase("Motorsailer")) {
						boatType = BoatType.Motorsailer;
					} else if (type.equalsIgnoreCase("Canoe")) {
						boatType = BoatType.Canoe;
					} else if (type.equalsIgnoreCase("Other")) {
						boatType = BoatType.Other;
					} else {
						throw new IllegalStateException("Unsupported boat type.");
					}
					
					newBoat.setType(boatType);
					
					this.boatController.update(member, oldBoat, newBoat);
					break;
				}
			case 9: /* Delete Boat */
				{
					int memId = Integer.parseInt(console.getInput("Member id: "));
					Member member = database.getMember(memId);
					
					Boat boat = member.getBoats().get(Integer.parseInt(console.getInput("Boat Number: ")));
					
					this.boatController.delete(member, boat);
					break;
				}
			case 10: /* View Boat */
				{
					int memId = Integer.parseInt(console.getInput("Member id: "));
					Member member = database.getMember(memId);
					
					Boat boat = member.getBoats().get(Integer.parseInt(console.getInput("Boat Number: ")));
					
					this.boatController.view(boat);
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
