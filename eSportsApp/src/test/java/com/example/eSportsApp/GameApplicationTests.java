package com.example.eSportsApp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.eSportsApp.apis.GameService;
import com.example.eSportsApp.entities.Game;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameApplicationTests {

	@Autowired
	GameService gameService;
	
	@Autowired
	Game game;
	
	@Test
	public void exampleGameTest() {
		System.out.println("Game test case scenarios");
	}
	
	@Test
	public void addGameUsingService() {
		game.setGameId(1);
		game.setDate("30/07/2019");
		game.setType("Best of 5");
		game = gameService.registerOrUpdatePlayer(game);
		assertNotNull(game);
	}
	
/*	@Test
	public void findByGameIdUsingService() {
		int gameId = 1;
		assertNotNull(gameService.findByGameId(gameId));
	}
	
	@Test
	public void deleteByGameIdUsingService() {
		int gameId = 60;
		gameService.deleteByGameId(gameId);
		assertNull(gameService.findByGameId(gameId));
	}*/
}
