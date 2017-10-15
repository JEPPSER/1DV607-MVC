package com.jesper.mvc.controller;

import com.jesper.mvc.model.Member;
import com.jesper.mvc.persistence.Database;
import com.jesper.mvc.view.MemberView;

/**
 * MemberController class that acts as a connection between the Data storage of 
 * members and the view.
 */
public class MemberController {
	
	private Database database;
	private MemberView memberView;
	
	/**
	 * Constructs a new MemberController by initializing all members
	 * to their default values.
	 */
	public MemberController() {
		this.database = Database.getInstance();
		this.memberView = new MemberView();
	}
	
	/**
	 * Creates a new member in the data storage using the specified member
	 * object.
	 * 
	 * @param value - Member object to store.
	 */
	public void create(Member value) {
		database.createMember(value);
	}

	/**
	 * Updates a stored member with the specified ID to the specified member object.
	 * 
	 * @param id - ID of target member to update.
	 * @param value - New member object to update to.
	 */
	public void update(int id, Member value) {
		database.updateMember(id, value);
	}

	/**
	 * Deletes a stored member with the specified ID.
	 * 
	 * @param id - ID of the target member to delete from storage.
	 * 
	 * @return - Deleted member object.
	 */
	public Member delete(int id) {
		Member m = database.getMember(id);
		database.deleteMember(id);
		
		return m;
	}

	/**
	 * Views the member with the specified ID.
	 * 
	 * @param index - Index of target member to view.
	 */
	public void view(int index) {
		this.memberView.viewCompact(database.getMemberAt(index));
	}

	/**
	 * Views a more verbose message of the member with the specified ID.
	 * 
	 * @param index - Index of the target member to view.
	 */
	public void viewVerbose(int index) {
		this.memberView.viewVerbose(database.getMemberAt(index)); 
	}
}
