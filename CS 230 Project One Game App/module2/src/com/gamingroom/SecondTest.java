/**
 * @student Tyler Coplan
 * @course CS 230
 * @assignment Project 1
 * @date November 5, 2020
 * 
 * TESTING PURPOSES ONLY!!!!
 */

package com.gamingroom;
import java.util.List;
public class SecondTest {
	
	public void testSecondTest() {
		GameService service = GameService.getInstance();
		
		service.addGame("SecondTestClassGame");
		Game game = service.getGame("SecondTestClassGame");
		game.addTeam("Test Team 3 - "); //should not create this team
		game.addTeam("Team tester 1");
		game.addTeam("team tester 2");
		game.addTeam("Test Team 1 - 0"); // should not create this team
		List<Team> teams = game.getTeams();
		for (int i = 0; i < teams.size(); i++) {
			Team team = teams.get(i);
			team.addPlayer("THE ONE AND ONLY"); // SHOULD NOT ADD
			team.addPlayer("Player Tester"); // should only be on team 1
			team.addPlayer("Player tester " + Integer.toString(i));
		}
	}
}
