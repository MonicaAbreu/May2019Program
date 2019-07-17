package com.example.eSportsApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="JPA1_GAME")
@EntityListeners({GameLifecycleListener.class})
public class Game {
	
	@Value("-1")
	private int gameId;
	
	@Value("Default date")
	private String date;
	
	@Value("Default type game")
	private String type;
	
	
	
	public Game() {
		System.out.println("Game created");
	}

	@Id
	@Column(name="game_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	@Column(name="game_date", nullable=false, length=10)
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name="game_type", nullable=false, length=10)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", date=" + date + ", type=" + type + "]";
	}
}
