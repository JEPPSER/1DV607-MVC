package com.jesper.mvc.model;

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
	// TODO: Add list of boats.
	
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
}
