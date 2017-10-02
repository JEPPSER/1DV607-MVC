package com.jesper.mvc.controller;

import java.util.ArrayList;

import com.jesper.mvc.model.Boat;
import com.jesper.mvc.model.Member;
import com.jesper.mvc.view.BoatView;

/**
 * MemberController class that acts as a connection between the Data storage of 
 * boats and the view.
 * 
 * @author Oskar
 */
public class BoatController {
	
	private BoatView boatView;
	
	/**
	 * Constructs a new BoatController by initializing all members
	 * to their default values.
	 */
	public BoatController() {
		this.boatView = new BoatView();
	}
	
	/**
	 * Stores a new Boat for the specified Member.
	 * 
	 * @param member - Member to store boat for.
	 * @param value - Boat object to store for the member.
	 */
	public void create(Member member, Boat value) {
		member.addBoat(value);
	}

	/**
	 * Updates a boat from the selected Member.
	 * 
	 * @param member - Member to update boat for.
	 * @param oldValue - Target boat to update.
	 * @param newVal - New value for the boat to be updated to.
	 */
	public void update(Member member, Boat oldValue, Boat newVal) {
		ArrayList<Boat> memberBoats = member.getBoats();
		
		int i = memberBoats.indexOf(oldValue);
		
		if (i == -1) {
			throw new IllegalArgumentException("Specified Boat doesn't exist!");
		}
		
		memberBoats.set(i, newVal);
	}

	/**
	 * Deletes a specified boat from the specified Member.
	 * 
	 * @param member - Member to remove boat from.
	 * @param value - Target boat to remove.
	 * 
	 * @return - Boat object that was removed.
	 */
	public Boat delete(Member member, Boat value) {
		ArrayList<Boat> memberBoats = member.getBoats();
		
		int i = memberBoats.indexOf(value);
		Boat b = memberBoats.get(i);
		memberBoats.remove(i);
		
		return b;
	}

	/**
	 * View the specified boat.
	 * 
	 * @param value - Target boat to view.
	 */
	public void view(Boat value) {
		this.boatView.view(value);
	}
}
