package com.jesper.mvc.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesper.mvc.model.Member;

/**
 * 
 * @author Oskar
 *
 */
public class Database {
	
	private ArrayList<Member> members;
	private ObjectMapper mapper;
	
	/**
	 * 
	 */
	public Database() {
		this.members = new ArrayList<>();
		this.mapper = new ObjectMapper();
	}
	
	/**
	 * 
	 * @param m
	 */
	public void createMember(Member m) {
		if (this.members.contains(m)) {
			throw new IllegalArgumentException("Member already exists!");
		}
		
		if (this.members.isEmpty()) {
			m.setId(0);
		} else {
			m.setId(this.members.get(this.members.size()-1).getId() + 1);
		}
		
		this.members.add(m);
	}
	
	public Member getMember(int id) {
		return this.members.get(id);
	}
	
	public void updateMember(int id, Member m) {
		this.members.set(id, m);
	}
	
	public void deleteMember(int id) {
		this.members.remove(id);
	}
	
	public void save() {
		try {
			mapper.writeValue(new File("Members.json"), this.members);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void load() {
		File jsonFile = new File("Members.json");
		try {
			this.members = mapper.readValue(jsonFile, new TypeReference<List<Member>>(){});
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (Member m : members) {
			System.out.println(m.getName());
		}
	}
	
	public int getTotalMembers() {
		return this.members.size();
	}
}
