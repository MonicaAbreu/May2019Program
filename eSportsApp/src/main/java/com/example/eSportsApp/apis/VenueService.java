package com.example.eSportsApp.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.eSportsApp.entities.Venue;
import com.example.eSportsApp.repositories.VenueRepository;

@Component
@Scope("singleton")
public class VenueService {
	
	@Autowired
	private VenueRepository venueRepository;
	
	public VenueService() {
		System.out.println("Venue Service created");
	}

	public Venue registerOrUpdateVenue(Venue venue) {
		venue = venueRepository.save(venue);
		System.out.println("Venue registered " + venue);
		return venue;
	}
	
	public Venue findByVenueId(int venueId) {
		try {
			return venueRepository.findById(venueId).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deleteByVenueId(int venueId) {
		venueRepository.deleteById(venueId);
	}
}
