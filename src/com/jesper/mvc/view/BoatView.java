package com.jesper.mvc.view;

import com.jesper.mvc.model.Boat;

/**
 * 
 * @author Jesper Bergstrom
 * @name BoatView.java
 * @version 0.00.00
 */
public class BoatView {
	
	/**
	 * Returns a string describing the boat.
	 * 
	 * @param boat
	 * @return string
	 */
	public String view(Boat boat){
		String result = "Boat: " + boat.getType();
		return result;
	}
}
