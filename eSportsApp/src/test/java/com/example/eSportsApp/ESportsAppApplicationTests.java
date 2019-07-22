package com.example.eSportsApp;

import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.eSportsApp.apis.GameService;
import com.example.eSportsApp.apis.PlayerService;
import com.example.eSportsApp.apis.VenueService;
import com.example.eSportsApp.entities.Game;
import com.example.eSportsApp.entities.Player;
import com.example.eSportsApp.entities.Team;
import com.example.eSportsApp.entities.Venue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ESportsAppApplicationTests {
	
	@Autowired
	VenueService venueService;
	
	@Autowired 
	PlayerService playerService;
	
	@Autowired
	GameService gameService;

	
	//Associating One to Many - Team to Players
	@Test
	public void assignTeamToPlayer() {
		int playerId = 31;
		int teamId = 146;
		
		Player p1 = playerService.assignTeam(playerId, teamId);
		assertNotNull(p1.getCurrentTeam());
	}
	
	//Associating One to many - Venue to Games
	@Test
	public void assignVenueToGame() {
		int gameId = 149;
		int venueId = 1;
		
		Game g1 = gameService.assignVenue(gameId, venueId);
		assertNotNull(g1.getCurrentVenue());
	}
	
	//Associating Many to Many - Teams to Games
	@Test
	public void assignTeamToGame() {
		int gameId = 149;
		int teamId = 146;
		
		Set<Team> teams = gameService.assignTeam(gameId, teamId);
		assertNotNull(teams);
		System.out.println(teams);
	}
	

	@Test
	public void simpleTest() {
		System.out.println("System Test Executed");
	}
}
