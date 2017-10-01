package com.jesper.mvc.controller;

import com.jesper.mvc.model.Member;
import com.jesper.mvc.persistence.Database;

/**
 * 
 * @author Oskar
 *
 */
public class MemberController implements IController<Member> {
	
	private Database database;
	
	/**
	 * 
	 * @param database
	 */
	public MemberController(Database database) {
		this.database = database;
	}
	
	@Override
	public void create(Member value) {
		database.createMember(value);
	}

	@Override
	public void update(int id, Member value) {
		database.updateMember(id, value);
	}

	@Override
	public Member delete(int id) {
		Member m = database.getMember(id);
		database.deleteMember(id);
		
		return m;
	}

	@Override
	public void view(int id) {
		database.getMember(id);
		//TODO: Send to member view.
	}

}
