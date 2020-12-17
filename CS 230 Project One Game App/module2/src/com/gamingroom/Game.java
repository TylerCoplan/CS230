package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 * 
 * @student Tyler Coplan
 * @course CS 230
 *  @assignment Project 1
 * @date November 13, 2020
 */
public class Game extends Entity {
	/**
	 * List of teams in game
	 *
	 */
	private List<Team> teams = new ArrayList<Team>();

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
	}

	/**
	 * Adds team to game - returns existing team if team already exists in game
	 * Iterates all games, not just current game
	 * 
	 * @return team Team object
	 */
	public Team addTeam(String name) {
		// need to iterate all games to check all team names
		GameService service = GameService.getInstance();
		List<Game> games = service.getGames();
		Iterator<Game> gamesIterator = games.iterator();
		
		// declares a null team to fill with unique data or return null if team already exists
		Team team = null;
		
		// Iterates team list for every game and returns the Team object if the name already exists
		while (gamesIterator.hasNext()) {
			Game game = gamesIterator.next();
			List<Team> allTeams = game.getTeams();
			Iterator<Team> teamsIterator = allTeams.iterator();
			while (teamsIterator.hasNext()) {
				Team tempTeam = teamsIterator.next();
				if (name.equals(tempTeam.getName())) {
					return tempTeam;
				}
			}
		}
		
		// Gets next team id from game service and adds team to game
		team = new Team(service.getNextTeamId(), name);
		teams.add(team);
		return team;
	}

	@Override
	public String toString() {
		
		return "Game [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
	
//*********THESE FUNCTIONS WERE ADDED FOR TESTING/NECESSARY FUNCTIONALITY************
	/**
	 * Returns the list of teams for the current game
	 * 
	 * @return List<Team> list of teams for current game
	 */
	public List<Team> getTeams() {
		return teams;
	}
	
	/**
	 * Searches for team in current game, returns null if not found
	 * 
	 * @param teamName - name of team to find
	 * @return
	 */
	public Team getTeam (String teamName) {
		Team team = null;
		Iterator<Team> teamsIterator = teams.iterator();
		
		while (teamsIterator.hasNext()) {
			Team nextTeam = teamsIterator.next();
			if (teamName.equals(nextTeam.getName())) {
				return nextTeam;
			}
		}
		return team;
		
	}
}
