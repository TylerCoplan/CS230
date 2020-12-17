package com.gamingroom;

/**
 * Parent class for player, team and game objects.
 * 
 * @student Tyler Coplan
 * @course CS 230
 *  @assignment Project 1
 * @date November 13, 2020
 */

public class Entity {
	
	/**
	 * Class data members - protected allows child classes to inherit 
	 */
	private long id;
	private String name;
	
	/**
	 * Protected constructor to restrict public access, allow for child constructors
	 */
	private Entity() {
	}
	
	/**
	 * Public constructor forces users to enter data to create players, teams or games
	 * 
	 * @params id unique id, name unique name
	 */
	
	public Entity(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Returns ID of base class id number
	 * 
	 * @return id unique id num
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Returns name of base class object
	 * 
	 * @return name unique name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * To string method (should not be used by parent class, implement in base classes).
	 */
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}

}
