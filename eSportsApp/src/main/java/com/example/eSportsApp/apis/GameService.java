package com.example.eSportsApp.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.eSportsApp.entities.Game;
import com.example.eSportsApp.repositories.GameRepository;

@Component
@Scope("singleton")
public class GameService {
	@Autowired
	private GameRepository gameRepository;
	
	public GameService() {
		System.out.println("Game Service created");
	}
	
	public Game registerOrUpdatePlayer(Game game) {
		game = gameRepository.save(game);
		System.out.println("Game registered " + game);
		return game;
	}
	
	public Game findByGameId(int gameId) {
		try {
			return gameRepository.findById(gameId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deleteByGameId(int gameId) {
		gameRepository.deleteById(gameId);
	}
}
