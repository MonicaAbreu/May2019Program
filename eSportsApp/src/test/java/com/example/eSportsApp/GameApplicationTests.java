package com.example.eSportsApp;

import static org.junit.Assert.assertNotNull;

import java.util.Set;

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
	
/*	@Test
	public void addGameUsingService() {
		Game game1 = new Game();
		game1.setGameId(1);
		game1.setDate("30/07/2019");
		game1.setType("Best of 3");
		game1 = gameService.registerOrUpdatePlayer(game1);
		assertNotNull(game1);
		
		Game game2 = new Game();
		game2.setGameId(2);
		game2.setDate("31/07/2019");
		game2.setType("Best of 5");
		game2 = gameService.registerOrUpdatePlayer(game2);
		assertNotNull(game2);
	}*/
	
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
