package com.jesper.mvc.view;

import com.jesper.mvc.model.Member;

/**
 * Class for representing a Member graphically.
 * 
 * @author Jesper Bergstrom
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
	public String viewCompact(Member member){
		String result = "Member: " + member.getName();
		return result;
	}
	
	/**
	 * View a verbose version of a member. It will
	 * display all the information about a member.
	 * 
	 * @param member
	 * @return formatted string representing a member
	 */
	public String viewVerbose(Member member){
		String result = "[Member]\n";
		result += "Name: " + member.getName() + "\n";
		result += "Personal number: " + member.getPersonalNumber() + "\n";
		result += "ID: " + member.getId();
		return result;
	}
}
