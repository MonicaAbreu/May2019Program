package com.example.eSportsApp.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.eSportsApp.entities.Player;
import com.example.eSportsApp.repositories.PlayerRepository;

@Component
@Scope("singleton")
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	public PlayerService() {
		System.out.println("Player Service created");
	}
	
	public Player registerOrUpdatePlayer(Player player) {
		player = playerRepository.save(player);
		System.out.println("Player registered " + player);
		return player;
	}
	
	public Player findByPlayerId(int playerId) {
		try {
			return playerRepository.findById(playerId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deleteByPlayerId(int playerId) {
		playerRepository.deleteById(playerId);
	}

}
