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
@Table(name="JPA1_TEAM")
@EntityListeners({TeamLifecycleListener.class})
public class Team {

	@Value("-1")
	private int teamId;
	
	@Value("Default team name")
	private String name;
	
	@Value("Default team alias")
	private String alias;
	
	@Value("-1")
	private int rank;
	
	@Value("Default team coach")
	private String coach;
	
	public Team() {
		System.out.println("Team created");
	}
	
	@Id
	@Column(name="team_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	@Column(name="team_name", nullable=false, length=20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="team_alias", nullable=false, length=10)
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@Column(name="team_rank", nullable=false)
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Column(name="team_coach", nullable=false)
	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", alias=" + alias + ", rank=" + rank + ", coach=" + coach
				+ "]";
	}
}
