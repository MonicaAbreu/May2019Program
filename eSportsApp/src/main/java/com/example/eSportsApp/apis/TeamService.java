package com.example.eSportsApp.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.eSportsApp.entities.Team;
import com.example.eSportsApp.repositories.TeamRepository;

@Component
@Scope("singleton")
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	public TeamService() {
		System.out.println("Team Service created");
	}
	
	public Team registerOrUpdateTeam(Team team) {
		team = teamRepository.save(team);
		System.out.println("Team registered " + team);
		return team;
	}
	
	public Team findByTeamId(int teamId) {
		try {
			return teamRepository.findById(teamId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deleteByTeamId(int teamId) {
		teamRepository.deleteById(teamId);
	}
}
