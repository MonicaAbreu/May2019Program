package com.example.eSportsApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.eSportsApp.entities.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

}
