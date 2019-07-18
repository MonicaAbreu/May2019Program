package com.example.eSportsApp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.eSportsApp.apis.VenueService;
import com.example.eSportsApp.entities.Venue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VenueApplicationTests {

	@Autowired
	VenueService venueService;
	
	@Autowired
	Venue venue;
	
	@Test
	public void exampleVenueTest() {
		System.out.println("Venue test case scenarios");
	}
	
/*	@Test
	public void addVenueUsingService() {
		venue.setVenueId(3);
		venue.setLocation("China");
		venue.setEvent("CS:GO Asia Championships");
		venue = venueService.registerOrUpdateVenue(venue);
		assertNotNull(venue);
	}*/
	
/*	@Test
	public void findByVenueIdUsingService() {
		int venueId = 33;
		assertNotNull(venueService.findByVenueId(venueId));
	}
	
	@Test
	public void deleteByVenueIdUsingService() {
		int venueId = 46;
		venueService.deleteByVenueId(venueId);
		assertNull(venueService.findByVenueId(venueId));
	}*/
}

