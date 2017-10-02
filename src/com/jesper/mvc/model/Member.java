package com.jesper.mvc.model;

import java.util.ArrayList;

/**
 * Class representing a member of a boat/yacht club.
 * 
 * @author Jesper Bergstrom
 * @name Member.java
 * @version 0.00.00
 */
public class Member {
	
	private String name;
	private int personalNumber;
	private int id;
	private ArrayList<Boat> boats;
	
	public Member() {
		this.boats = new ArrayList<>();
	}
	
	public Member(String name, int personalNumber) {
		this.name = name;
		this.personalNumber = personalNumber;
	}
	
	/**
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Sets name of member.
	 * 
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * @return personal number
	 */
	public int getPersonalNumber(){
		return personalNumber;
	}
	
	/**
	 * Sets personal number.
	 * 
	 * @param personal number.
	 */
	public void setPersonalNumber(int personalNumber){
		this.personalNumber = personalNumber;
	}
	
	/**
	 * @return id
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * Sets id.
	 * 
	 * @param id
	 */
	public void setId(int id){
		this.id = id;
	}

	/**
	 * @return the boats
	 */
	public ArrayList<Boat> getBoats() {
		return boats;
	}
	
	/**
	 * @param boats
	 */
	public void setBoats(ArrayList<Boat> boats) {
		this.boats = boats;
	}

	/**
	 * @param boats the boats to set
	 */
	public void addBoat(Boat boat) {
		this.boats.add(boat);
	}
	
	/**
	 * 
	 * @param boat
	 */
	public void removeBoat(Boat boat) {
		this.boats.remove(boat);
	}
}
