package com.example.eSportsApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.eSportsApp.apis.GameService;
import com.example.eSportsApp.apis.PlayerService;
import com.example.eSportsApp.apis.TeamService;
import com.example.eSportsApp.apis.VenueService;
import com.example.eSportsApp.entities.Game;
import com.example.eSportsApp.entities.Player;
import com.example.eSportsApp.entities.Team;
import com.example.eSportsApp.entities.Venue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ESportsAppApplicationTests {

	@Autowired
	PlayerService playerService;
	
	@Autowired
	Player player;
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	Team team;
	
	@Autowired 
	GameService gameService;
	
	@Autowired
	Game game;
	
	@Autowired
	VenueService venueService;
	
	@Autowired
	Venue venue;
	
	@Test
	public void manageAssociations() {
		Venue v1 = new Venue();
		v1.setLocation("Location");
		v1.setEvent("Name Event");
		
		Venue v2 = new Venue();
		v2.setLocation("Location2");
		v2.setEvent("Name Event2");
		
		Game g1 = new Game();
		g1.setDate("Game Date");
		g1.setType("Game Type");
		
		Game g2 = new Game();
		g2.setDate("Game Date2");
		g2.setType("Game Type2");
		
		Team t1 = new Team();
		t1.setName("Team Name");
		t1.setAlias("T1");
		t1.setCoach("Coach Name");
		t1.setRank(10);
		
		Team t2 = new Team();
		t2.setName("Team Name2");
		t2.setAlias("T2");
		t2.setCoach("Coach Name2");
		t2.setRank(10);
		
		Team t3 = new Team();
		t3.setName("Team Name3");
		t3.setAlias("T3");
		t3.setCoach("Coach Name3");
		t3.setRank(10);
		
		Team t4 = new Team();
		t4.setName("Team Name4");
		t4.setAlias("T4");
		t4.setCoach("Coach Name4");
		t4.setRank(10);
		
		Player p1 = new Player();
		p1.setName("Player1");
		p1.setAlias("P1");
		p1.setAge(20);
		p1.setNationality("Nationality");
		p1.setRole("Player role");
		
		Player p2 = new Player();
		p2.setName("Player2");
		p2.setAlias("P2");
		p2.setAge(20);
		p2.setNationality("Nationality");
		p2.setRole("Player role");
		
		Player p3 = new Player();
		p3.setName("Player3");
		p3.setAlias("P3");
		p3.setAge(20);
		p3.setNationality("Nationality");
		p3.setRole("Player role");
		
		Player p4 = new Player();
		p4.setName("Player4");
		p4.setAlias("P4");
		p4.setAge(20);
		p4.setNationality("Nationality");
		p4.setRole("Player role");
		
		Player p5 = new Player();
		p5.setName("Player5");
		p5.setAlias("P5");
		p5.setAge(20);
		p5.setNationality("Nationality");
		p5.setRole("Player role");
		
		Player p6 = new Player();
		p6.setName("Player6");
		p6.setAlias("P6");
		p6.setAge(20);
		p6.setNationality("Nationality");
		p6.setRole("Player role");
		
		Player p7 = new Player();
		p7.setName("Player7");
		p7.setAlias("P7");
		p7.setAge(20);
		p7.setNationality("Nationality");
		p7.setRole("Player role");
		
		Player p8 = new Player();
		p8.setName("Player8");
		p8.setAlias("P8");
		p8.setAge(20);
		p8.setNationality("Nationality");
		p8.setRole("Player role");
		
		Player p9 = new Player();
		p9.setName("Player9");
		p9.setAlias("P9");
		p9.setAge(20);
		p9.setNationality("Nationality");
		p9.setRole("Player role");
		
		Player p10 = new Player();
		p10.setName("Player10");
		p10.setAlias("P10");
		p10.setAge(20);
		p10.setNationality("Nationality");
		p10.setRole("Player role");
		
		Player p11 = new Player();
		p11.setName("Player11");
		p11.setAlias("P11");
		p11.setAge(20);
		p11.setNationality("Nationality");
		p11.setRole("Player role");
		
		Player p12 = new Player();
		p12.setName("Player12");
		p12.setAlias("P12");
		p12.setAge(20);
		p12.setNationality("Nationality");
		p12.setRole("Player role");
		
		Player p13 = new Player();
		p13.setName("Player13");
		p13.setAlias("P13");
		p13.setAge(20);
		p13.setNationality("Nationality");
		p13.setRole("Player role");
		
		Player p14 = new Player();
		p14.setName("Player14");
		p14.setAlias("P14");
		p14.setAge(20);
		p14.setNationality("Nationality");
		p14.setRole("Player role");
		
		Player p15 = new Player();
		p15.setName("Player15");
		p15.setAlias("P15");
		p15.setAge(20);
		p15.setNationality("Nationality");
		p15.setRole("Player role");
		
		Player p16 = new Player();
		p16.setName("Player16");
		p16.setAlias("P16");
		p16.setAge(20);
		p16.setNationality("Nationality");
		p16.setRole("Player role");
		
		Player p17 = new Player();
		p17.setName("Player17");
		p17.setAlias("P17");
		p17.setAge(20);
		p17.setNationality("Nationality");
		p17.setRole("Player role");
		
		Player p18 = new Player();
		p18.setName("Player18");
		p18.setAlias("P18");
		p18.setAge(20);
		p18.setNationality("Nationality");
		p18.setRole("Player role");
		
		Player p19 = new Player();
		p19.setName("Player19");
		p19.setAlias("P19");
		p19.setAge(20);
		p19.setNationality("Nationality");
		p19.setRole("Player role");
		
		Player p20 = new Player();
		p20.setName("Player20");
		p20.setAlias("P20");
		p20.setAge(20);
		p20.setNationality("Nationality");
		p20.setRole("Player role");
	
		
		//One to many - one venue has many games
		v1.getGames().add(g1);
		v1.getGames().add(g2);
		
		//One to many - one game has many teams
		g1.getMembers().add(t1);
		g1.getMembers().add(t2);
		
		g2.getMembers().add(t3);
		g2.getMembers().add(t4);
		
		//One to many - one team has many players
		t1.getMembers().add(p1);
		t1.getMembers().add(p2);
		t1.getMembers().add(p3);
		t1.getMembers().add(p4);
		t1.getMembers().add(p5);
		
		t2.getMembers().add(p6);
		t2.getMembers().add(p7);
		t2.getMembers().add(p8);
		t2.getMembers().add(p9);
		t2.getMembers().add(p10);
		
		t3.getMembers().add(p11);
		t3.getMembers().add(p12);
		t3.getMembers().add(p13);
		t3.getMembers().add(p14);
		t3.getMembers().add(p15);
		
		t4.getMembers().add(p16);
		t4.getMembers().add(p17);
		t4.getMembers().add(p18);
		t4.getMembers().add(p19);
		t4.getMembers().add(p20);
		
		//Many to one - each game has a venue
		g1.setCurrentVenue(v1);
		g2.setCurrentVenue(v2);
		
		//Many to one - each team has a game
		t1.setCurrentGame(g1);
		t2.setCurrentGame(g1);
		t3.setCurrentGame(g2);
		t4.setCurrentGame(g2);
		
		//Many to one - each player has a team
		p1.setCurrentTeam(t1);
		p2.setCurrentTeam(t1);
		p3.setCurrentTeam(t1);
		p4.setCurrentTeam(t1);
		p5.setCurrentTeam(t1);
		
		p6.setCurrentTeam(t2);
		p7.setCurrentTeam(t2);
		p8.setCurrentTeam(t2);
		p9.setCurrentTeam(t2);
		p10.setCurrentTeam(t2);
		
		p11.setCurrentTeam(t3);
		p12.setCurrentTeam(t3);
		p13.setCurrentTeam(t3);
		p14.setCurrentTeam(t3);
		p15.setCurrentTeam(t3);
		
		p16.setCurrentTeam(t4);
		p17.setCurrentTeam(t4);
		p18.setCurrentTeam(t4);
		p19.setCurrentTeam(t4);
		p20.setCurrentTeam(t4);
	}
	
	@Test
	public void simpleTest() {
		System.out.println("System Test Executed");
	}
}
