package com.example.eSportsApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.eSportsApp.entities.Team;

public interface TeamRepository extends CrudRepository<Team, Integer> {

}
