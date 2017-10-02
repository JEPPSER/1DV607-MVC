package com.jesper.mvc.persistence;

import java.io.File;
import java.io.FileNotFoundException;
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
 * Database class that acts as a data storage using JSON for the entire application.
 * Retrieving objects stored and modifying them goes through this class. This class is implemented
 * as a singleton to prevent multiple users.
 * 
 * @author Oskar
 */
public class Database {
	
	private ArrayList<Member> members;
	private ObjectMapper mapper;
	
	private static Database INSTANCE;
	
	/**
	 * Default constructor that initializes all members to default values and then
	 * proceeds with loading the already stored database.
	 */
	private Database() {
		this.members = new ArrayList<>();
		this.mapper = new ObjectMapper();
		
		this.load();
	}
	
	/**
	 * Getter for the instance of this Singleton.
	 * 
	 * @return Instance of this singleton.
	 */
	public static Database getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Database();
		}
		
		return INSTANCE;
	}
	
	/**
	 * Adds a new member to the data storage if the member doesn't already exist.
	 * The member added gets an ID assigned to it.
	 * 
	 * @param m - Target member to add.
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
	
	/**
	 * Retrieves member with target ID from the storage.
	 * 
	 * @param id - ID for target member.
	 * 
	 * @return - Member retrieved from specified ID; null if not found.
	 */
	public Member getMember(int id) {
		for (Member m : this.members) {
			if (m.getId() == id) {
				return m;
			}
		}
		
		return null;
	}
	
	/**
	 * Retrieves Member at the target index from storage.
	 * 
	 * @param index - Index of target member.
	 * 
	 * @return - Member retrieved from specified index.
	 */
	public Member getMemberAt(int index) {
		return this.members.get(index);
	}
	
	/**
	 * Updates the member with the specified ID.
	 * 
	 * @param id - ID for target member to update.
	 * @param m - Member object to replace the old one with.
	 */
	public void updateMember(int id, Member m) {
		for (Member member : this.members) {
			if (member.getId() == id) {
				int i = this.members.indexOf(member);
				m.setBoats(this.members.get(i).getBoats());
				this.members.set(i, m);
			}
		}
	}
	
	/**
	 * Deletes member with specified ID from the storage.
	 * 
	 * @param id - ID for target member to delete.
	 */
	public void deleteMember(int id) {
		for (Member m : this.members) {
			if (m.getId() == id) {
				this.members.remove(m);
			}
		}
	}
	
	/**
	 * Saves the data storage to file.
	 */
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
	
	/**
	 * Loads the data storage from file.
	 */
	public void load() {
		File jsonFile = new File("Members.json");
		try {
			this.members = mapper.readValue(jsonFile, new TypeReference<List<Member>>(){});
			
		} catch (FileNotFoundException e) {
			// No stored data was found.
		}catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Getter for the total number of members stored within the data storage.
	 * 
	 * @return - Total number of members.
	 */
	public int getTotalMembers() {
		return this.members.size();
	}
}
