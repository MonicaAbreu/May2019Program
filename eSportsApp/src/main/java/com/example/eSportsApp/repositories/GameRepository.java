package com.example.eSportsApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.eSportsApp.entities.Game;

public interface GameRepository extends CrudRepository<Game, Integer>{

}
