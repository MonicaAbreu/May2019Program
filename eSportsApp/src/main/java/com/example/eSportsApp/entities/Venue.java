package com.example.eSportsApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name="JPA1_VENUE")
@EntityListeners({VenueLifecycleListener.class})
public class Venue {
	
	@Value("-1")
	private int venueId;
	
	@Value("Default location")
	private String location;
	
	@Value("Default name of event")
	private String event;
	
	
	
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
