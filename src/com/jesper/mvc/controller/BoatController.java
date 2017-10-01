package com.jesper.mvc.controller;

import com.jesper.mvc.model.Boat;
import com.jesper.mvc.persistence.Database;

/**
 * 
 * @author Oskar
 *
 */
public class BoatController {
	
	private Database database;
	
	/**
	 * 
	 * @param database
	 */
	public BoatController(Database database) {
		this.database = database;
	}
	
	public void create(int memberId, Boat value) {
		this.database.getMember(memberId).addBoat(value);
	}

	public void update(int memberId, Boat value) {
		
	}

	public Boat delete(int memberId, Boat value) {
		return null;
	}

	public void view(Boat value) {
		
	}
}
