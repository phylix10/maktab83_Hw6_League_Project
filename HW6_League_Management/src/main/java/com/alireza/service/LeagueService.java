package com.alireza.service;

import com.alireza.model.League;
import com.alireza.repository.LeagueRepository;

public class LeagueService {
    public void addLeague(League league){
        if (LeagueRepository.findLeague(league) == null){
            LeagueRepository.addLeague(league);
            System.out.println("add league successfully");
        }
        else {
            System.out.println("A league has already been registered with this name in this sport!");
        }
    }
}
