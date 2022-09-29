package com.alireza.service;

import com.alireza.model.*;
import com.alireza.repository.VolleyballRepository;

import java.util.List;

public class VolleyballService implements LeagueFacilities{
    ClubService clubService = new ClubService();
    VolleyballMatchService volleyballMatchService = new VolleyballMatchService();

    @Override
    public void addTeam(Clubs club) {
        if (clubService.createVolleyballClub(club)){
            VolleyballRepository.addClubToLeague(club);
            System.out.println("add club to volleyball league was successfully");
        }
        else {
            System.out.println("A club with this name is already registered in this league!");
        }
    }

    @Override
    public void deleteTeam(Clubs club) {
        if (clubService.deleteVolleyballClub(club)) {
            VolleyballRepository.deleteClubFromLeague(club);
            System.out.println(club.getName() + " team was successfully eliminated");
        }
        else {
            System.out.println("No team with this name was found in this league");
        }
    }

    public void doMatch(VolleyballMatches volleyballMatches) {
        if (clubService.findVolleyballClub(volleyballMatches.getHostTeam())){
            if (clubService.findVolleyballClub(volleyballMatches.getGuestTeam())){
                volleyballMatchService.addMatch(volleyballMatches);
                System.out.println("The match is done");
                if (volleyballMatches.getHostSets() > volleyballMatches.getGuestSets()){
                    if (volleyballMatches.getHostSets() == 3 && volleyballMatches.getGuestSets() == 0){
                        VolleyballRepository.winHost3Guest0(volleyballMatches);
                        VolleyballRepository.lostGuest0Host3(volleyballMatches);
                    }
                    else if (volleyballMatches.getHostSets() == 3 && volleyballMatches.getGuestSets() == 1){
                        VolleyballRepository.winHost3Guest1(volleyballMatches);
                        VolleyballRepository.lostGuest1Host3(volleyballMatches);
                    }
                    else if (volleyballMatches.getHostSets() == 3 && volleyballMatches.getGuestSets() == 2){
                        VolleyballRepository.winHost3Guest2(volleyballMatches);
                        VolleyballRepository.lostGuest2Host3(volleyballMatches);
                    }
                    else{
                        System.out.println("The game sets are not correct!");
                    }
                }
                else if (volleyballMatches.getHostSets() < volleyballMatches.getGuestSets()){
                    if (volleyballMatches.getHostSets() == 0 && volleyballMatches.getGuestSets() == 3){
                        VolleyballRepository.lostHost0Guest3(volleyballMatches);
                        VolleyballRepository.winGuest3Host0(volleyballMatches);
                    }
                    else if (volleyballMatches.getHostSets() == 1 && volleyballMatches.getGuestSets() == 3){
                        VolleyballRepository.lostHost1Guest3(volleyballMatches);
                        VolleyballRepository.winGuest3Host1(volleyballMatches);
                    }
                    else if (volleyballMatches.getHostSets() == 2 && volleyballMatches.getGuestSets() == 3){
                        VolleyballRepository.lostHost2Guest3(volleyballMatches);
                        VolleyballRepository.winGuest3Host2(volleyballMatches);
                    }
                    else {
                        System.out.println("The game sets are not correct!");
                    }
                }
            }
            else {
                System.out.println("No team with name " + volleyballMatches.getHostTeam().getName() + "was found in this league");
            }
        }
        else {
            System.out.println("No team with name " + volleyballMatches.getGuestTeam().getName() + "was found in this league");
        }
    }

    @Override
    public void showClubDetail(Clubs club) {
        if (clubService.findVolleyballClub(club)){
            System.out.println(VolleyballRepository.showClubDetail(club));
        }
        else {
            System.out.println("No team with this name was found in this league");
        }
    }

    @Override
    public void showTable() {
        List<VolleyballTable> list = VolleyballRepository.showVolleyballTable();
        if (list != null) {
            for (VolleyballTable i : list){
                System.out.println(i);
            }
        }
    }
}
