package com.example.eSportsApp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class VenueLifecycleListener {
	@PrePersist 
	public void beforeInsert(Venue v) {
		System.out.println("Before Insert: "+ v);
	}

	@PostPersist
	public void afterInsert(Venue v) {
		System.out.println("After Insert: "+ v);
	}
	
	@PreUpdate 
	public void beforeUpdate(Venue v) {
		System.out.println("Before Update: "+ v);
	}

	@PostUpdate
	public void afterUpdate(Venue v) {
		System.out.println("After Update: "+ v);
	}
	
	@PreRemove
	public void beforeDelete(Venue v) {
		System.out.println("Before Delete: "+ v);
	}

	@PostLoad
	public void afterSelect(Venue v) {
		System.out.println("After Select: "+ v);
	}	
}
