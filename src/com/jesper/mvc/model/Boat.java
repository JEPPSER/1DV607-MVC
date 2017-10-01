package com.jesper.mvc.model;

/**
 * Class representing a Boat.
 * 
 * @author Oskar
 */
public class Boat {
	
	/**
	 * Enum for the different types of Boats.
	 * 
	 * @author Oskar
	 */
	public enum BoatType {
		Sailboat,
		Motorsailer,
		Canoe,
		Other
	}
	
	private BoatType type;
	private double length;
	
	/**
	 * Default constructor for the Boat object.
	 */
	public Boat() {
		
	}
	
	/**
	 * Constructor creating a new Boat object with the specified BoatType and length.
	 * 
	 * @param type - BoatType of the boat to create.
	 * @param length - Length of the boat to create.
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
