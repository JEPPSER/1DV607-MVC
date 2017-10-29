package com.jesper.mvc.model;

import java.util.ArrayList;

/**
 * Class representing a member of a boat/yacht club.
 * 
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
	 * @return total number of boats.
	 */
	public int getTotalBoats() {
		return this.boats.size();
	}
	
	/**
	 * @param index - Index of boat to retrieve.
	 * 
	 * @return boat at specified index.
	 */
	public Boat getBoatAt(int index) {
		return this.boats.get(index);
	}
	
	/**
	 * @param boat - Boat to get index of.
	 * 
	 * @return Boat at specified index.
	 */
	public int getBoatIndex(Boat boat) {
		return this.boats.indexOf(boat);
	}
	
	/**
	 * @param index - Index of boat to replace.
	 * 
	 * @param boat - Boat to set at the specified index.
	 */
	public void setBoatAt(int index, Boat boat) {
		this.boats.set(index, boat);
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
