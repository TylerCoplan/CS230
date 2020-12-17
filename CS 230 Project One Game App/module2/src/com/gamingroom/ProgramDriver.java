package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu 
 * 
 * @student Tyler Coplan
 * @course CS 230
 * @assignment Project 1
 * @date November 13, 2020
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		/*
		 * Gets the only instance of GameService object
		 */
		GameService service = GameService.getInstance();
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();

//		additional test code to verify singleton pattern and iterator pattern 
		// create another instance of game service
		GameService service2 = GameService.getInstance();
		
		for (int i = 1; i < 3; i++) {
			String name = "Game " + Integer.toString(i);
			service2.addGame(name);
		}
		
		System.out.println("\nAbout to test two different instances of game service...");
		System.out.println(service.addGame("Game 3"));
		System.out.println(service2.addGame("Game 3"));
		System.out.println(service2.addGame("Game Test"));
		System.out.println(service.addGame("Game Test"));
		System.out.println(service.getGame(1));
		System.out.println(service2.getGame(1));
		System.out.println(service.getGameCount());
		System.out.println(service2.getGameCount());
		
		// run singleton again to test game service
		tester.testSingleton();
		
		// just to test the service after adding singleton game
		
		// prints out each game, each team in each game, and each player on each team
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
		
		// adding a whole bunch of dummy test data
		int a = 0; // used to create unique player names
		
		// iterates for each game and adds 3 test teams to 1 game and 2 to all others
		// since each subsequent test team 3 entry attempt will fail because it already exists
		for (int i = 0; i < service.getGameCount(); i++) {
			tester.testSingleton();
			Game game = service.getGame(i);
			game.addTeam("Test Team 1 - " + Integer.toString(i));
			game.addTeam("Test Team 2 - " + Integer.toString(i));
			game.addTeam("Test Team 3 - ");
			
			// iterates each team in the current game and adds test players to each game
			for (int j = 0; j < game.getTeams().size(); j++) {
				Team team = game.getTeams().get(j);
				team.addPlayer("TEST PLAYER " + Integer.toString(a));
				a++;
				team.addPlayer("TEST PLAYER " + Integer.toString(a));
				a--;
				// attempts to add the same player as the first TEST PLAYER on the team
				team.addPlayer("TEST PLAYER " + Integer.toString(a));
				// increase a to a new unused value
				a++;
				a++;
				//test for same named player
				team.addPlayer("THE ONE AND ONLY");
			}
			
			// simulating another user adding a game and teams
			if (i == 4) {
				SecondTest tester2 = new SecondTest();
				tester2.testSecondTest();
			}
			// test local game service
			if (i == 5) {
				for (int z = 0; z < service.getGameCount(); z++) {
					System.out.println(service.getGame(z));
					Game game11 = service.getGame(z);
					System.out.println(game11.getTeams());
					for (int j = 0; j < game11.getTeams().size(); j++) {
						Team team = game11.getTeams().get(j);
						System.out.print("Team "+ team.getName() + ": ");
						System.out.println(team.getPlayers());
					}
				}
			}
		}
		
		// and a whole bunch more test data printing
		tester.testSingleton();
		
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
	}
}
