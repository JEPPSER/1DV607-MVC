package com.jesper.mvc.model;

/**
 * 
 * @author Oskar
 *
 */
public class Boat {
	
	/**
	 * 
	 * @author Oskar
	 *
	 */
	public enum BoatType {
		Sailboat,
		Motorsailer,
		Canoe,
		Other
	}
	
	/**
	 * 
	 */
	private BoatType type;
	private double length;
	
	public Boat() {
		
	}
	
	/**
	 * 
	 * @param type
	 * @param length
	 */
	public Boat(BoatType type, double length) {
		this.type = type;
		this.length = length;
	}

	/**
	 * @return the type
	 */
	public BoatType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(BoatType type) {
		this.type = type;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}
}
