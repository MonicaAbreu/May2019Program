package com.example.eSportsApp.apis;

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

import com.example.eSportsApp.entities.Player;
import com.example.eSportsApp.entities.Team;
import com.example.eSportsApp.repositories.PlayerRepository;

@Component
@Scope("singleton")
@Path("/players/")
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private TeamService teamService;
	
	public PlayerService() {
		System.out.println("Player Service created");
	}
	
	@POST //HTTP method to send the form data
	@Path("/register") //URL pattern
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //form data
	@Produces(MediaType.APPLICATION_JSON) //JSON data
	public Player registerOrUpdatePlayer(@BeanParam Player player) {
		System.out.println(player);
		player = playerRepository.save(player);
		System.out.println("Player registered " + player);
		return player;
	}
	
	@Path("/find/{playerId}")
	@GET //HTTP method used to call the API
	@Produces(MediaType.APPLICATION_JSON)
	public Player findByPlayerId(@PathParam("playerId") int playerId) {
		try {
			return playerRepository.findById(playerId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE //delete HTTP Method
	@Path("/delete/{playerId}")
	public void deleteByPlayerId(@PathParam("playerId") int playerId) {
		playerRepository.deleteById(playerId);
	}

	//spring ensures that db session is open until all the operations in this method across repositories are completed
	//used to fetch all collections which are initialised using Lazy initialisation 
	@Transactional
	@POST //HTTP method
	@Path("/assign/team") //URL 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //input format
	@Produces(MediaType.APPLICATION_JSON) //output format
	public Player assignTeam(@FormParam("playerId") int playerId, 
							 @FormParam("teamId") int teamId) {
		try {
			Player player = findByPlayerId(playerId);
			Team team = teamService.findByTeamId(teamId);
			
			team.getMembers().add(player);
			player.setCurrentTeam(team);
			
			player = registerOrUpdatePlayer(player);
			return player;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
