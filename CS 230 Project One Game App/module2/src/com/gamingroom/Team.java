package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 * @student Tyler Coplan
 * @course CS 230
 * @assignment Project 1
 * @date November 5, 2020
 */
public class Team extends Entity{
	/**
	 * List of players on team
	 */
	private List<Player> players = new ArrayList<Player>();
	
	/**
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}
	
	/**
	 * Adds a player to the team - returns existing player object if player already exists on a team
	 * Iterates every game and every team on every game to ensure no duplicate player names
	 * 
	 * @param String player's name
	 * @return player Player object
	 */
	public Player addPlayer(String name) {
		// need to iterate all games to check all team names
		GameService service = GameService.getInstance();
		List<Game> games = service.getGames();
		Iterator<Game> gamesIterator = games.iterator();
		
		// declares a null team to fill with unique data or return null if team already exists
		Player player = null;
		
		// Iterates every game and every team and returns the player object if the name already exists
		while (gamesIterator.hasNext()) {
			Game game = gamesIterator.next();
			List<Team> allTeams = game.getTeams();
			Iterator<Team> teamsIterator = allTeams.iterator();
			while (teamsIterator.hasNext()) {
				Team tempTeam = teamsIterator.next();
				List<Player> allPlayers = tempTeam.getPlayers();
				Iterator<Player> playerIterator = allPlayers.iterator();
				while (playerIterator.hasNext()) {
					Player tempPlayer = playerIterator.next();
					if (name.equals(tempPlayer.getName())) {
						return tempPlayer;
					}
				}
			}
		}
		
		// gets next player id from game service and adds player to team
		player = new Player(service.getNextPlayerId(), name);
		players.add(player);
		return player;
	}


	@Override
	public String toString() {
		return "Team [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
	
	// Function added for testing purposes and for ensuring player names do not duplicate
	public List<Player> getPlayers() {
		return players;
	}
}
