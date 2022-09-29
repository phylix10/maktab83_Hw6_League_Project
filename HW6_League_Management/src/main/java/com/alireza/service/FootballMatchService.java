package com.alireza.service;

import com.alireza.model.FootballMatches;
import com.alireza.repository.FootballMatchRepository;


public class FootballMatchService {
    public void addMatch(FootballMatches footballMatches){
        FootballMatchRepository.doMatch(footballMatches);
    }
}
