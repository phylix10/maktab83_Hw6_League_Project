package com.alireza.model;

import java.util.Objects;

public class Clubs {
    private League leagueType;
    private String name;
    private String coach;
    private String stadium;
    private int numberOfPlayer;
    private int numberOfCups;

    public Clubs() {
    }

    public Clubs(String name) {
        this.name = name;
    }

    public Clubs(League leagueType, String name, String coach, String stadium, int numberOfPlayer, int numberOfCups) {
        this.leagueType = leagueType;
        this.name = name;
        this.coach = coach;
        this.stadium = stadium;
        this.numberOfPlayer = numberOfPlayer;
        this.numberOfCups = numberOfCups;
    }

    public League getLeagueType() {
        return leagueType;
    }

    public String getName() {
        return name;
    }

    public String getCoach() {
        return coach;
    }

    public String getStadium() {
        return stadium;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public int getNumberOfCups() {
        return numberOfCups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clubs clubs = (Clubs) o;
        return numberOfPlayer == clubs.numberOfPlayer && numberOfCups == clubs.numberOfCups && leagueType.equals(clubs.leagueType) && name.equals(clubs.name) && coach.equals(clubs.coach) && stadium.equals(clubs.stadium);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leagueType, name, coach, stadium, numberOfPlayer, numberOfCups);
    }

    @Override
    public String toString() {
        return "Clubs{" +
                "leagueType=" + leagueType +
                ", name='" + name + '\'' +
                ", coach='" + coach + '\'' +
                ", stadium='" + stadium + '\'' +
                ", numberOfPlayer=" + numberOfPlayer +
                ", numberOfCups=" + numberOfCups +
                '}';
    }
}
