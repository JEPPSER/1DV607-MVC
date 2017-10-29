package com.jesper.mvc.controller;

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
			
			console.displayCommands();
			
			switch(console.getAction()) {
			case VIEW_ALL_MEMBERS: /* View All Members */
				{
					int total = this.database.getTotalMembers();
					for (int i = 0; i < total; i++) {
						this.memberController.view(i);
					}

					break;
				}
			case VIEW_ALL_MEMBERS_VERBOSE: /* View All Members Verbose */
				{
					int total = this.database.getTotalMembers();
					
					for (int i = 0; i < total; i++) {
						this.memberController.viewVerbose(i);
					}
					
					break;
				}
			case CREATE_MEMBER: /* Create Member */
				{
					Member member = new Member();
					
					console.displayName();
					String name = console.getInput();
					
					console.displayPersonalNumber();
					int personalNumber =  console.getInputNumber();
					
					member.setName(name);
					member.setPersonalNumber(personalNumber);
					this.memberController.create(member);
					break;
				}
			case UPDATE_MEMBER: /* Update Member */
				{
					console.displayMemberId();
					int memId = console.getInputNumber();
					boolean memIdExist = false;
					
					int totalMembers = this.database.getTotalMembers();
					
					while (memIdExist == false) {
						for (int i = 0; i < totalMembers; i++) {
							Member m = this.database.getMember(i);
							
							if (m.getId() == memId) {
								memIdExist = true;
								break;
							}
						}
						if (memIdExist == true) {
							break;
						}
						
						console.displayInvalidInput();
						memId = console.getInputNumber();
					}
					
					Member newMember = new Member();
					
					console.displayName();
					newMember.setName(console.getInput());
					
					console.displayPersonalNumber();
					newMember.setPersonalNumber(console.getInputNumber());
					
					this.memberController.update(memId, newMember);
					break;
				}
			case DELETE_MEMBER: /* Delete Member */
				{
					console.displayMemberId();
					int memId = console.getInputNumber();
					boolean memIdExist = false;
					
					int totalMembers = this.database.getTotalMembers();
					
					while (memIdExist == false) {
						for (int i = 0; i < totalMembers; i++) {
							Member m = this.database.getMember(i);
							
							if (m.getId() == memId) {
								memIdExist = true;
								break;
							}
						}
						if (memIdExist == true) {
							break;
						}
						console.displayInvalidInput();
						memId = console.getInputNumber();
					}
					
					this.memberController.delete(memId);
					break;
				}
			case VIEW_MEMBER: /* View Member */
				{
					console.displayMemberId();
					int memId = console.getInputNumber();
					boolean memIdExist = false;
					
					int totalMembers = this.database.getTotalMembers();
					
					while (memIdExist == false) {
						for (int i = 0; i < totalMembers; i++) {
							Member m = this.database.getMember(i);
							
							if (m.getId() == memId) {
								memIdExist = true;
								break;
							}
						}
						if (memIdExist == true) {
							break;
						}
						
						console.displayInvalidInput();
						memId = console.getInputNumber();
					}
					
					this.memberController.view(memId);
					break;
				}
			case CREATE_BOAT: /* Create Boat */
				{
					console.displayMemberId();
					int memId = console.getInputNumber();
					boolean memIdExist = false;
					
					int totalMembers = this.database.getTotalMembers();
					
					while (memIdExist == false) {
						for (int i = 0; i < totalMembers; i++) {
							Member m = this.database.getMember(i);
							
							if (m.getId() == memId) {
								memIdExist = true;
								break;
							}
						}
						if (memIdExist == true) {
							break;
						}
						console.displayInvalidInput();
						memId = console.getInputNumber();
					}
					
					Member member = this.database.getMember(memId);
					
					console.displayBoatLength();
					double length = console.getInputDouble();
					BoatType boatType = null;
					
					console.displayBoatType();
					String type = console.getInput();
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
							console.displayInvalidInput();
							type = console.getInput();
						}
					}
					
					Boat boat = new Boat();
					boat.setLength(length);
					boat.setType(boatType);
					
					this.boatController.create(member, boat);
					break;
				}
			case UPDATE_BOAT: /* Update Boat */
				{
					console.displayMemberId();
					int memId = console.getInputNumber();
					boolean memIdExist = false;
					
					int totalMembers = this.database.getTotalMembers();
					
					while (memIdExist == false) {
						for (int i = 0; i < totalMembers; i++) {
							Member m = this.database.getMember(i);
							
							if (m.getId() == memId) {
								memIdExist = true;
								break;
							}
						}
						if (memIdExist == true) {
							break;
						}
						
						console.displayInvalidInput();
						memId = console.getInputNumber();
					}
					
					Member member = database.getMember(memId);
					
					console.displayBoatNumber();
					int boatIndex = console.getInputNumber();
					
					while (boatIndex < 0 || boatIndex > member.getTotalBoats()) {
						console.displayInvalidInput();
						boatIndex = console.getInputNumber();
					}
					
					Boat oldBoat = member.getBoatAt(boatIndex);
					Boat newBoat = new Boat();
					console.displayBoatLength();
					newBoat.setLength(console.getInputDouble());
					
					BoatType boatType = null;
					
					console.displayBoatType();
					String type = console.getInput();
					
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
							console.displayInvalidInput();
							type = console.getInput();
						}
					}
					
					newBoat.setType(boatType);
					
					this.boatController.update(member, oldBoat, newBoat);
					break;
				}
			case DELETE_BOAT: /* Delete Boat */
				{
					console.displayMemberId();
					int memId = console.getInputNumber();
					boolean memIdExist = false;
					
					int totalMembers = this.database.getTotalMembers();
					
					while (memIdExist == false) {
						for (int i = 0; i < totalMembers; i++) {
							Member m = this.database.getMember(i);
							
							if (m.getId() == memId) {
								memIdExist = true;
								break;
							}
						}
						if (memIdExist == true) {
							break;
						}
						
						console.displayInvalidInput();
						memId = console.getInputNumber();
					}
					Member member = database.getMember(memId);
					
					console.displayBoatNumber();
					int boatIndex = console.getInputNumber();
					
					while (boatIndex < 0 || boatIndex > member.getTotalBoats()) {
						console.displayInvalidInput();
						boatIndex = console.getInputNumber();
					}
					
					Boat boat = member.getBoatAt(boatIndex);
					
					this.boatController.delete(member, boat);
					break;
				}
			case VIEW_BOAT: /* View Boat */
				{
					console.displayMemberId();
					int memId = console.getInputNumber();
					boolean memIdExist = false;
					
					int totalMembers = this.database.getTotalMembers();
					
					while (memIdExist == false) {
						for (int i = 0; i < totalMembers; i++) {
							Member m = this.database.getMember(i);
							
							if (m.getId() == memId) {
								memIdExist = true;
								break;
							}
						}
						if (memIdExist == true) {
							break;
						}
						console.displayInvalidInput();
						memId = console.getInputNumber();
					}
					Member member = database.getMember(memId);
					
					console.displayBoatNumber();
					int boatIndex = console.getInputNumber();
					
					while (boatIndex < 0 || boatIndex > member.getTotalBoats()) {
						console.displayInvalidInput();
						boatIndex = console.getInputNumber();
					}
					
					Boat boat = member.getBoatAt(boatIndex);
					
					this.boatController.view(boat);
					break;
				}
			case QUIT: /* Quit application. */
				{
					this.database.save();
					return;
				}
			case NOACTION:
			default:
				break;
			}
		}
	}
}
