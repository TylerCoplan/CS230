package com.gamingroom;

/**
 * A simple class to hold information about a player
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a player is
 * created.
 * </p>
 * @author coce@snhu.edu
 * 
 * @student Tyler Coplan
 * @course CS 230
 * @assignment Project 1
 * @date November 13, 2020
 */
public class Player extends Entity{
	
	/**
	 * Public player constructor
	 */
	public Player(long id, String name) {
		super(id, name);
	}
	
	@Override
	public String toString() {
		return "Player [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
}
