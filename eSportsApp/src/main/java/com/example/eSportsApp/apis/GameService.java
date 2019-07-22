package com.example.eSportsApp.apis;

import java.util.Set;

import javax.transaction.Transactional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import com.example.eSportsApp.entities.Venue;
import com.example.eSportsApp.repositories.GameRepository;

@Component
@Scope("singleton")
@Path("/games/")
public class GameService {
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private VenueService venueService;
	
	@Autowired
	private TeamService teamService;
	
	
	public GameService() {
		System.out.println("Game Service created");
	}
	
	@POST //HTTP method to send the form data
	@Path("/register") //URL pattern
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //form data
	@Produces(MediaType.APPLICATION_JSON) //JSON data
	public Game registerOrUpdatePlayer(@BeanParam Game game) {
		game = gameRepository.save(game);
		System.out.println("Game registered " + game);
		return game;
	}
	
	@Path("/find/{gameId}")
	@GET //HTTP method used to call the API
	@Produces({
		MediaType.APPLICATION_JSON, //object to be given in JSON
		MediaType.APPLICATION_XML	//object to be given in XML
	})
	public Game findByGameId(@PathParam("gameId") int gameId) {
		try {
			return gameRepository.findById(gameId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE //delete HTTP Method
	@Path("/delete/{gameId}")
	public void deleteByGameId(@PathParam("gameId") int gameId) {
		gameRepository.deleteById(gameId);
	}

	//spring ensures that db session is open until all the operations in this method across repositories are completed
	//used to fetch all collections which are initialised using Lazy initialisation 
	@Transactional
	@POST //HTTP method
	@Path("/assign/venue") //URL 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //input format
	@Produces(MediaType.APPLICATION_JSON) //output format
	public Game assignVenue(@PathParam("gameId") int gameId, 
							@PathParam("venueId") int venueId) {
		try {
			Game game = findByGameId(gameId);
			Venue venue = venueService.findByVenueId(venueId);
			//manage the associations
			venue.getGames().add(game);
			game.setCurrentVenue(venue);
			//update the entity to save the association
			game = registerOrUpdatePlayer(game);
			return game;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@POST //HTTP method
	@Path("/assign/team") //URL 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //input format
	@Produces(MediaType.APPLICATION_JSON) //output format
	public Set<Team> assignTeam(@PathParam("gameId") int gameId, 
								@PathParam("teamId") int teamId) {
		try {
			Game game = findByGameId(gameId);
			Team team = teamService.findByTeamId(teamId);
			//since it is Many to Many, we just need to assign in on direction
			game.getGameTeams().add(team);
			return game.getGameTeams();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
