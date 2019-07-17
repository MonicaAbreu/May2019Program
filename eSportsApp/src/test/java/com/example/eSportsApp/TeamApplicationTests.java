package com.example.eSportsApp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.eSportsApp.apis.TeamService;
import com.example.eSportsApp.entities.Team;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamApplicationTests {

	@Autowired
	TeamService teamService;
	
	@Autowired
	Team team;
	
	@Test
	public void exampleTeamTest() {
		System.out.println("Team test case scenarios");
	}
	
/*	@Test
	public void addTeamUsingService() {
		team.setTeamId(3);
		team.setName("Luminosity Gaming");
		team.setAlias("LG");
		team.setRank(3);
		team.setCoach("Rafael Fernandes");
		team = teamService.registerOrUpdateTeam(team);
		assertNotNull(team);
	}
	
	@Test
	public void findByTeamIdUsingService() {
		int teamId = 50;
		assertNotNull(teamService.findByTeamId(teamId));
	}*/
	
/*	@Test
	public void deleteByTeamIdUsingService() {
		int teamId = 60;
		teamService.deleteByTeamId(teamId);
		assertNull(teamService.findByTeamId(teamId));
	}*/
}
