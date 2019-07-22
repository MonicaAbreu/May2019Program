package com.example.eSportsApp.apis;

import java.util.Set;

import javax.transaction.Transactional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.eSportsApp.entities.Game;
import com.example.eSportsApp.entities.Team;
import com.example.eSportsApp.repositories.TeamRepository;


@Component
@Scope("singleton")
@Path("/teams/")
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private GameService gameService;
	
	public TeamService() {
		System.out.println("Team Service created");
	}
	
	@POST //HTTP method to send the form data
	@Path("/register") //URL pattern
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //form data
	@Produces(MediaType.APPLICATION_JSON) //JSON data
	public Team registerOrUpdateTeam(@BeanParam Team team) {
		team = teamRepository.save(team);
		System.out.println("Team registered " + team);
		return team;
	}
	
	@Path("/find/{teamId}")
	@GET //HTTP method used to call the API
	@Produces(MediaType.APPLICATION_JSON)
	public Team findByTeamId(@PathParam("teamId") int teamId) {
		try {
			return teamRepository.findById(teamId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE //delete HTTP Method
	@Path("/delete/{teamId}")
	public void deleteByTeamId(@PathParam("teamId") int teamId) {
		teamRepository.deleteById(teamId);
	}

	
	@Transactional
	@POST //HTTP method
	@Path("/assign/game") //URL 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //input format
	@Produces(MediaType.APPLICATION_JSON) //output format
	public Set<Game> assignGame(@FormParam("teamId") int teamId, 
								@FormParam("gameId") int gameId) {
		try {
			Team team = findByTeamId(teamId);
			Game game = gameService.findByGameId(gameId);
			//since it is Many to Many, we just need to assign in on direction
			team.getTeamGames().add(game);
			//update the association in the join table
			team = registerOrUpdateTeam(team);
			return team.getTeamGames();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
