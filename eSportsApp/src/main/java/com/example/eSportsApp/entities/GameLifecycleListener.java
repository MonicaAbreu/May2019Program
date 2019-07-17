package com.example.eSportsApp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class GameLifecycleListener {
	@PrePersist 
	public void beforeInsert(Game g) {
		System.out.println("Before Insert: "+ g);
	}

	@PostPersist
	public void afterInsert(Game g) {
		System.out.println("After Insert: "+ g);
	}
	
	@PreUpdate 
	public void beforeUpdate(Game g) {
		System.out.println("Before Update: "+ g);
	}

	@PostUpdate
	public void afterUpdate(Game g) {
		System.out.println("After Update: "+ g);
	}
	
	@PreRemove
	public void beforeDelete(Game g) {
		System.out.println("Before Delete: "+ g);
	}

	@PostLoad
	public void afterSelect(Game g) {
		System.out.println("After Select: "+ g);
	}
	
}
