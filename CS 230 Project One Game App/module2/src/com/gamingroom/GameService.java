package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 * 
 * @student Tyler Coplan
 * @course CS 230
 * @assignment Project 1
 * @date November 13, 2020
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId;
	
	/**
	 * Holds the next player identifier
	 */
	private static long nextPlayerId;
	
	/**
	 * Holds the next team identifier
	 */
	private static long nextTeamId;
	
	/* The following GameService class member, private constructor, and getInstance()
	 * method demonstrates the Singleton Pattern.  It is used to ensure only one game service
	 * exists by hiding the game service constructor from public use and returning the only 
	 * game service created by the class itself.  The pattern is required to ensure that all
	 * games are accessible by the users and no duplicate games can be created.
	 *
	 * Creates an instance of GameService 
	 */
	private static GameService instance = new GameService();

	/**
	 * Private constructor ensures object cannot be created outside of class
	 */
	private GameService() {

	}
	
	/**
	 * Returns the only object of GameService
	 * 
	 * @return the only GameService object
	 */
	public static GameService getInstance() {
		return instance;
	}
	
	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */

	public Game addGame(String name) {

		// a local game instance
		Game game = null;
		
		/*
		 * This is the first use of the iterator pattern, found in the java utility package.
		 * The Iterator interface object will iterate through the list of games and has methods
		 * to help me do that.  hasNext() determines if there is a next object while next()
		 * returns that object.
		 * 
		 * References: 
		 * Singh, C. "Java Iterator With Examples." beginnersbook.com 
		 *     Accessed at https://beginnersbook.com/2014/06/java-iterator-with-examples/
		 *     
		 * Java Docs https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html#iterator--
		 */
		// creates iterator object to iterate games list
		Iterator<Game> iterateGames = games.iterator();
		
		// EFFICIENCY CHANGE?
		/**
		 * I used the existing algorithm to determine if the game exists or not already.  Shouldn't the
		 * while loop just return the game if it already exists and end the function?
		 * That is the solution I came up with in the Team.addPlayer() and Game.addTeam functions.
		 */
		// iterates list of games while there is a next object
		while (iterateGames.hasNext()) {
			Game nextGame = iterateGames.next();    // gets object of next game to iterate
			if (nextGame.getName().equals(name)) {  // compares game name to method argument
				game = nextGame;                    // sets game to next game if names match
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		
		/*
		 * This is the second use of the iterator pattern, found in the java utility package.
		 * The iterateGames object will provide methods to iterate the list of games.  I know this
		 * violates the DRY and I could have perhaps created a method but I did not want to add
		 * anything not in the UML design.
		 */
		// iterator object iterates the list of games
		Iterator<Game> iterateGames = games.iterator();
		
		// iterates games list while there is still a next game
		while (iterateGames.hasNext()) {
			Game nextGame = iterateGames.next();    // creates object to hold next game
			if (nextGame.getId() == id) {           // compares next game id to method argument
				game = nextGame;                    // sets game to next game if id's match
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		/*
		 * This is the third use of the iterator pattern, found in the java utility package.
		 * Same as the previous two uses.  Sorry for the repetition.
		 */
		// creates iterator object to iterate games list
		Iterator<Game> iterateGames = games.iterator();
		
		// iterates list of games while there is a next object
		while (iterateGames.hasNext()) {
			Game nextGame = iterateGames.next();    // gets object of next game to iterate
			if (nextGame.getName().equals(name)) {  // compares game name to method argument
				game = nextGame;                    // sets game to next game if names match
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	/**
	 * Returns next player id and increments player id
	 * 
	 * @return long player id
	 */
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
	
	/**
	 * Returns next team id and increments the next team id
	 * 
	 * @return long teamId
	 */
	public long getNextTeamId() {
		return nextTeamId++;
	}
	
//**********THIS FUNCTION WAS ADDED FOR TESTING/REQUIRED FUNCTIONALITY**************
	
	public List<Game> getGames() {
		return games;
	}
}
