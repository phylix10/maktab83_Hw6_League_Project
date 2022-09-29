package com.alireza.service;

import com.alireza.model.Clubs;
import com.alireza.repository.ClubRepository;

public class ClubService {
    public boolean createFootballClub(Clubs club){
        if (ClubRepository.findFootballClub(club) == null) {
            ClubRepository.createClub(club);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean deleteFootballClub(Clubs club){
        if (ClubRepository.findFootballClub(club) != null) {
            ClubRepository.deleteFootballClub(club);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean findFootballClub(Clubs club){
        return ClubRepository.findFootballClub(club) != null;
    }
    public boolean createVolleyballClub(Clubs club){
        if (ClubRepository.findVolleyballClub(club) == null) {
            ClubRepository.createClub(club);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean deleteVolleyballClub(Clubs club){
        if (ClubRepository.findVolleyballClub(club) != null) {
            ClubRepository.deleteVolleyballClub(club);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean findVolleyballClub(Clubs club){
        return ClubRepository.findVolleyballClub(club) != null;
    }
}
