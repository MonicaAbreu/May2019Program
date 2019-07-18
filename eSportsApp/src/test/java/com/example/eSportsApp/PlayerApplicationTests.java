package com.example.eSportsApp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.eSportsApp.apis.PlayerService;
import com.example.eSportsApp.entities.Player;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerApplicationTests {
	
	@Autowired
	PlayerService playerService;
	
	@Autowired
	Player player;
	
	@Test
	public void examplePlayerTest() {
		System.out.println("Player test case scenarios");
	}
	
/*	@Test
	public void addPlayerUsingService() {
		player.setPlayerId(15);
		player.setName("Jonathan Jablonowski");
		player.setAlias("EliGe");
		player.setRole("Entry");
		player.setAge(27);
		player.setNationality("American");
		player = playerService.registerOrUpdatePlayer(player);
		assertNotNull(player);
		
	}
	
	@Test
	public void findByPlayerIdUsingService() {
		int playerId = 33;
		assertNotNull(playerService.findByPlayerId(playerId));
	}*/
	
/*	@Test
	public void deleteByPlayerIdUsingService() {
		int playerId = 48;
		playerService.deleteByPlayerId(playerId);
		assertNull(playerService.findByPlayerId(playerId));
	}*/
}
