package com.alireza.service;

import com.alireza.model.VolleyballMatches;
import com.alireza.repository.VolleyballMatchRepository;

public class VolleyballMatchService {
    public void addMatch(VolleyballMatches volleyballMatches){
        VolleyballMatchRepository.doMatch(volleyballMatches);
    }
}
