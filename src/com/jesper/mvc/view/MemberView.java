package com.jesper.mvc.view;

import com.jesper.mvc.model.Member;

/**
 * Class for representing a Member graphically.
 * 
 * @name MemberView.java
 * @version 0.00.00
 */
public class MemberView {
	
	/**
	 * View a compact version of a member. It will
	 * display a limited amount of information.
	 * 
	 * @param member
	 * @return formatted string representing a member
	 */
	public void viewCompact(Member member){
		String result = "Member: " + member.getName() + "\n";
		result += "ID: " + member.getId() + "\n";
		result += "Boat count: " + member.getBoats().size() + "\n";
		System.out.println(result);
	}
	
	/**
	 * View a verbose version of a member. It will
	 * display all the information about a member.
	 * 
	 * @param member
	 * @return formatted string representing a member
	 */
	public void viewVerbose(Member member){
		String result = "[Member]\n";
		result += "Name: " + member.getName() + "\n";
		result += "Personal number: " + member.getPersonalNumber() + "\n";
		result += "ID: " + member.getId() + "\n";
		result += "Boats: \n";
		for(int i=0; i < member.getBoats().size(); i++){
			result += member.getBoats().get(i).getLength() + ", ";
			result += member.getBoats().get(i).getType() + "\n"; 
		}
		
		System.out.println(result);
	}
}
