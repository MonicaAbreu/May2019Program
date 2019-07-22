package com.example.eSportsApp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="JPA1_VENUE")
@EntityListeners({VenueLifecycleListener.class})
@XmlRootElement
public class Venue implements Serializable {
	
	private int venueId;
	
	@FormParam("location")
	private String location;
	
	@FormParam("event")
	private String event;
	
	//One to Many - One venue -> Many games
	private Set<Game> games = new HashSet<>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="currentVenue")
	@XmlTransient
	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	public Venue() {
		System.out.println("Venue created");
	}

	@Id
	@Column(name="venue_id")
	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	
	@Column(name="venue_location", nullable=false, length=45)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name="venue_event", nullable=false, length=30)
	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Venue [venueId=" + venueId + ", location=" + location + ", event=" + event + "]";
	}
}
