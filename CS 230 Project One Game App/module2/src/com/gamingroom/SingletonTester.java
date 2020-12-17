package com.gamingroom;


/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 * 
 * @student Tyler Coplan
 * @course CS 230
 * @assignment Project 1
 * @date November 5, 2020
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		/*
		 * Gets the instance of the GameService object
		 */
		GameService service = GameService.getInstance(); 

		// a simple for loop to print the games
		// was a simple loop, made more complex for team and player testing
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
			Game game = service.getGame(i);
			System.out.println(game.getTeams());
			for (int j = 0; j < game.getTeams().size(); j++) {
				Team team = game.getTeams().get(j);
				System.out.print("Team "+ team.getName() + ": ");
				System.out.println(team.getPlayers());
			}
		}
		
		System.out.println("\n\n");
		// Not that these objects are singletons, but they should not duplicate
		// if everything is working properly - I just wanted to add something that
		// would try to duplicate often to see if everything works right
		service.addGame("SINGLETON SHOWDOWN");
		Game game = service.getGame("SINGLETON SHOWDOWN");
		game.addTeam("THE ONLY SINGLETON TEAM");
		Team team = game.getTeam("THE ONLY SINGLETON TEAM");
		team.addPlayer("THE ONLY SINGLETON PLAYER");
	}
}
