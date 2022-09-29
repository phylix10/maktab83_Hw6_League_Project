package com.alireza.service;

import com.alireza.model.Clubs;
import com.alireza.model.FootballMatches;
import com.alireza.model.FootballTable;
import com.alireza.repository.FootballRepository;

import java.util.List;

public class FootballService implements LeagueFacilities{
    ClubService clubService = new ClubService();
    FootballMatchService footballMatchService = new FootballMatchService();

    @Override
    public void addTeam(Clubs club){
        if (clubService.createFootballClub(club)){
            FootballRepository.addClubToLeague(club);
            System.out.println("add club to football league was successfully");
        }
        else {
            System.out.println("A club with this name is already registered in this league!");
        }
    }

    @Override
    public void deleteTeam(Clubs club){
        if (clubService.deleteFootballClub(club)) {
            FootballRepository.deleteClubFromLeague(club);
            System.out.println(club.getName() + " team was successfully eliminated");
        }
        else {
            System.out.println("No team with this name was found in this league");
        }
    }

    public void doMatch(FootballMatches footballMatches){
        if (clubService.findFootballClub(footballMatches.getHostTeam())){
            if (clubService.findFootballClub(footballMatches.getGuestTeam())){
                footballMatchService.addMatch(footballMatches);
                System.out.println("The match is done");
                if (footballMatches.getHostGoals() > footballMatches.getGuestGoals()){
                    FootballRepository.winHostTeam(footballMatches);
                    FootballRepository.lostGuestTeam(footballMatches);
                }
                else if (footballMatches.getHostGoals() < footballMatches.getGuestGoals()){
                    FootballRepository.lostHostTeam(footballMatches);
                    FootballRepository.winGuestTeam(footballMatches);
                }
                else if (footballMatches.getHostGoals() == footballMatches.getGuestGoals()){
                    FootballRepository.draw(footballMatches);
                }
            }
            else {
                System.out.println("No team with name " + footballMatches.getHostTeam().getName() + "was found in this league");
            }
        }
        else {
            System.out.println("No team with name " + footballMatches.getGuestTeam().getName() + "was found in this league");
        }
    }

    @Override
    public void showClubDetail(Clubs clubs){
        if (clubService.findFootballClub(clubs)){
            System.out.println(FootballRepository.showClubDetail(clubs));
        }
        else {
            System.out.println("No team with this name was found in this league");
        }
    }

    @Override
    public void showTable(){
        List<FootballTable> list = FootballRepository.showFootballTable();
        if (list != null) {
            for (FootballTable i : list){
                System.out.println(i);
            }
        }
    }
}
