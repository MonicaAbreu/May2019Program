package com.example.eSportsApp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component

@Scope("prototype")
@Entity
@Table(name="JPA1_GAME")
@EntityListeners({GameLifecycleListener.class})
@XmlRootElement
public class Game implements Serializable {
	
	private int gameId;
	
	@FormParam("date")
	private String date;
	
	@FormParam("type")
	private String type;
	
	//Many to Many - many games have many teams
	private Set<Team> gameTeams = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="JPA1_GAMES_TEAMS",
				joinColumns=@JoinColumn(name="FK_GameId"),
				inverseJoinColumns=@JoinColumn(name="FK_TeamId"))
	@XmlTransient
	public Set<Team> getGameTeams() {
		return gameTeams;
	}

	public void setGameTeams(Set<Team> gameTeams) {
		this.gameTeams = gameTeams;
	}
	
	
	//Many to One - each game belong to one venue
	private Venue currentVenue;

	@ManyToOne
	@JoinColumn(name="FK_VenueId")
	public Venue getCurrentVenue() {
		return currentVenue;
	}

	public void setCurrentVenue(Venue currentVenue) {
		this.currentVenue = currentVenue;
	}

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
