package com.jesper.mvc.controller;

import java.util.ArrayList;

import com.jesper.mvc.model.Boat;
import com.jesper.mvc.model.Boat.BoatType;
import com.jesper.mvc.model.Member;
import com.jesper.mvc.persistence.Database;
import com.jesper.mvc.view.ConsoleView;

/**
 * ConsoleController handles actions to take depending on the console input retrieved from the ConsoleView.
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
			int cmd = console.getInputNumber(console.displayCommands());
			
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
					
					String name = console.getInput("Name: ");
					int personalNumber =  console.getInputNumber("Personal Number: ");
					
					member.setName(name);
					member.setPersonalNumber(personalNumber);
					this.memberController.create(member);
					break;
				}
			case 4: /* Update Member */
				{
					int memId = console.getInputNumber("Member id: ");
					boolean memIdExist = false;
					
					ArrayList<Member> members = this.database.getMembers();
					
					while (memIdExist == false) {
						for (Member m : members) {
							if (m.getId() == memId) {
								memIdExist = true;
								break;
							}
						}
						if (memIdExist == true) {
							break;
						}
						memId = console.getInputNumber("Invalid member id, Please enter a valid id: ");
					}
					
					Member newMember = new Member();
					newMember.setName(console.getInput("New Name: "));
					newMember.setPersonalNumber(console.getInputNumber("New Personal Number: "));
					
					this.memberController.update(memId, newMember);
					break;
				}
			case 5: /* Delete Member */
				{
					int memId = console.getInputNumber("Member id: ");
					boolean memIdExist = false;
					
					ArrayList<Member> members = this.database.getMembers();
					
					while (memIdExist == false) {
						for (Member m : members) {
							if (m.getId() == memId) {
								memIdExist = true;
								break;
							}
						}
						if (memIdExist == true) {
							break;
						}
						memId = console.getInputNumber("Invalid member id, Please enter a valid id: ");
					}
					
					this.memberController.delete(memId);
					break;
				}
			case 6: /* View Member */
				{
					int memId = console.getInputNumber("Member id: ");
					boolean memIdExist = false;
					
					ArrayList<Member> members = this.database.getMembers();
					
					while (memIdExist == false) {
						for (Member m : members) {
							if (m.getId() == memId) {
								memIdExist = true;
								break;
							}
						}
						if (memIdExist == true) {
							break;
						}
						memId = console.getInputNumber("Invalid member id, Please enter a valid id: ");
					}
					
					this.memberController.view(memId);
					break;
				}
			case 7: /* Create Boat */
				{
					int memId = console.getInputNumber("Member id: ");
					boolean memIdExist = false;
					
					ArrayList<Member> members = this.database.getMembers();
					
					while (memIdExist == false) {
						for (Member m : members) {
							if (m.getId() == memId) {
								memIdExist = true;
								break;
							}
						}
						if (memIdExist == true) {
							break;
						}
						memId = console.getInputNumber("Invalid member id, Please enter a valid id: ");
					}
					
					Member member = this.database.getMember(memId);
					
					double length = console.getInputDouble("Boat Length: ");
					BoatType boatType = null;
					String type = console.getInput("Boat Type(Sailboat, Motorsailer, Canoe, Other): ");
					type.toLowerCase();
					
					boolean invalidBoatType = true;
					
					while (invalidBoatType) {
						if (type.equalsIgnoreCase("Sailboat")) {
							boatType = BoatType.Sailboat;
							invalidBoatType = false;
						} else if (type.equalsIgnoreCase("Motorsailer")) {
							boatType = BoatType.Motorsailer;
							invalidBoatType = false;
						} else if (type.equalsIgnoreCase("Canoe")) {
							boatType = BoatType.Canoe;
							invalidBoatType = false;
						} else if (type.equalsIgnoreCase("Other")) {
							boatType = BoatType.Other;
							invalidBoatType = false;
						} else {
							type = console.getInput("Invalid Boat Type, Enter one of the following: Sailboat, Motorsailer, Canoe or Other: ");
						}
					}
					
					Boat boat = new Boat();
					boat.setLength(length);
					boat.setType(boatType);
					
					this.boatController.create(member, boat);
					break;
				}
			case 8: /* Update Boat */
				{
					int memId = console.getInputNumber("Member id: ");
					boolean memIdExist = false;
					
					ArrayList<Member> members = this.database.getMembers();
					
					while (memIdExist == false) {
						for (Member m : members) {
							if (m.getId() == memId) {
								memIdExist = true;
								break;
							}
						}
						if (memIdExist == true) {
							break;
						}
						memId = console.getInputNumber("Invalid member id, Please enter a valid id: ");
					}
					
					Member member = database.getMember(memId);
					int boatIndex = console.getInputNumber("Boat Number: ");
					
					while (boatIndex < 0 || boatIndex > member.getBoats().size()) {
						boatIndex = console.getInputNumber("Invalid Boat Number, try again: ");
					}
					
					Boat oldBoat = member.getBoats().get(boatIndex);
					Boat newBoat = new Boat();
					newBoat.setLength(console.getInputDouble("New Length: "));
					
					BoatType boatType = null;
					String type = console.getInput("Boat Type(Sailboat, Motorsailer, Canoe, Other): ");
					type.toLowerCase();
					
					boolean invalidBoatType = true;
					
					while (invalidBoatType) {
						if (type.equalsIgnoreCase("Sailboat")) {
							boatType = BoatType.Sailboat;
							invalidBoatType = false;
						} else if (type.equalsIgnoreCase("Motorsailer")) {
							boatType = BoatType.Motorsailer;
							invalidBoatType = false;
						} else if (type.equalsIgnoreCase("Canoe")) {
							boatType = BoatType.Canoe;
							invalidBoatType = false;
						} else if (type.equalsIgnoreCase("Other")) {
							boatType = BoatType.Other;
							invalidBoatType = false;
						} else {
							type = console.getInput("Invalid Boat Type, Enter one of the following: Sailboat, Motorsailer, Canoe or Other: ");
						}
					}
					
					newBoat.setType(boatType);
					
					this.boatController.update(member, oldBoat, newBoat);
					break;
				}
			case 9: /* Delete Boat */
				{
					int memId = console.getInputNumber("Member id: ");
					boolean memIdExist = false;
					
					ArrayList<Member> members = this.database.getMembers();
					
					while (memIdExist == false) {
						for (Member m : members) {
							if (m.getId() == memId) {
								memIdExist = true;
								break;
							}
						}
						if (memIdExist == true) {
							break;
						}
						memId = console.getInputNumber("Invalid member id, Please enter a valid id: ");
					}
					Member member = database.getMember(memId);
					
					int boatIndex = console.getInputNumber("Boat Number: ");
					
					while (boatIndex < 0 || boatIndex > member.getBoats().size()) {
						boatIndex = console.getInputNumber("Invalid Boat Number, try again: ");
					}
					
					Boat boat = member.getBoats().get(boatIndex);
					
					this.boatController.delete(member, boat);
					break;
				}
			case 10: /* View Boat */
				{
					int memId = console.getInputNumber("Member id: ");
					boolean memIdExist = false;
					
					ArrayList<Member> members = this.database.getMembers();
					
					while (memIdExist == false) {
						for (Member m : members) {
							if (m.getId() == memId) {
								memIdExist = true;
								break;
							}
						}
						if (memIdExist == true) {
							break;
						}
						memId = console.getInputNumber("Invalid member id, Please enter a valid id: ");
					}
					Member member = database.getMember(memId);
					
					int boatIndex = console.getInputNumber("Boat Number: ");
					
					while (boatIndex < 0 || boatIndex > member.getBoats().size()) {
						boatIndex = console.getInputNumber("Invalid Boat Number, try again: ");
					}
					
					Boat boat = member.getBoats().get(boatIndex);
					
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
