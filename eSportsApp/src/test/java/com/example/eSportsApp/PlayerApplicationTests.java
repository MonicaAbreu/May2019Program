package com.example.eSportsApp;

import static org.junit.Assert.assertNotNull;

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
	
	@Test
	public void addPlayerUsingService() {
		player.setPlayerId(1);
		player.setName("Monica Abreu");
		player.setAlias("Shazzam");
		player.setRole("AWP");
		player.setAge(24);
		player.setNationality("Portuguese");
		player = playerService.registerOrUpdatePlayer(player);
		assertNotNull(player);
		
	}

}
