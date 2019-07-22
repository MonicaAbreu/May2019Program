package com.example.eSportsApp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component

@Scope("prototype")
@Entity
@Table(name="JPA1_PLAYER")
@EntityListeners({PlayerLifecycleListener.class})
@XmlRootElement
public class Player implements Serializable {
	
	private int playerId;
	
	@FormParam("name")
	private String name;
	
	@FormParam("alias")
	private String alias;
	
	@FormParam("role")
	private String role;
	
	@FormParam("age")
	private int age;
	
	@FormParam("nationality")
	private String nationality;
	
	
	//Many to one - each player belongs to one team
	private Team currentTeam;
	
	@ManyToOne
	@JoinColumn(name="FK_TeamId")
	public Team getCurrentTeam() {
		return currentTeam;
	}

	public void setCurrentTeam(Team currentTeam) {
		this.currentTeam = currentTeam;
	}

	public Player() {
		System.out.println("Player created");
	}
	
	@Id //define this as the PK
	@Column(name="player_id") //column name
	@GeneratedValue(strategy=GenerationType.AUTO) //auto-numbering with a random starting number.
	//if I want to start from 1 use GenerationType.IDENTITY
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	@Column(name="player_name", nullable=false, length=45)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="player_alias", nullable=false, length=20)
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@Column(name="player_role", nullable=false, length=10)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(name="player_age", nullable=false)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Column(name="player_nationality", nullable=false, length=40)
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Player [playerID=" + playerId + ", name=" + name + ", alias=" + alias + ", role=" + role + ", age="
				+ age + ", nationality=" + nationality + "]";
	}

	
	
	
}
