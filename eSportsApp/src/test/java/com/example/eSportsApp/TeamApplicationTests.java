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
		Team team1 = new Team();
		team1.setTeamId(1);
		team1.setName("Ninjas in Pyjamas");
		team1.setAlias("NiP");
		team1.setRank(1);
		team1.setCoach("Faruk Pita");
		team1 = teamService.registerOrUpdateTeam(team1);
		assertNotNull(team1);
		
		Team team2 = new Team();
		team2.setTeamId(2);
		team2.setName("Natus Vincere");
		team2.setAlias("NaVi");
		team2.setRank(2);
		team2.setCoach("Mykhailo Blagin");
		team2 = teamService.registerOrUpdateTeam(team2);
		assertNotNull(team2);
		
		Team team3 = new Team();
		team3.setTeamId(3);
		team3.setName("Luminosity Gaming");
		team3.setAlias("LG");
		team3.setRank(3);
		team3.setCoach("Rafael Fernandes");
		team3 = teamService.registerOrUpdateTeam(team3);
		assertNotNull(team3);
	}*/

/*
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
