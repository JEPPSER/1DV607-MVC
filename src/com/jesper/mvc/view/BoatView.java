package com.jesper.mvc.view;

import com.jesper.mvc.model.Boat;

/**
 * 
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
	public void view(Boat boat){
		String result = "Boat: " + boat.getLength() + ", " + boat.getType();
		System.out.println(result);
	}
}
