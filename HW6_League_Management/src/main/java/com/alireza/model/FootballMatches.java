package com.alireza.model;

import java.util.Objects;

public class FootballMatches {
    private int matchId;
    private League matchType;
    private Clubs hostTeam;
    private int hostGoals;
    private Clubs guestTeam;
    private int guestGoals;

    public FootballMatches(League matchType, Clubs hostTeam, int hostGoals, Clubs guestTeam, int guestGoals) {
        this.matchType = matchType;
        this.hostTeam = hostTeam;
        this.hostGoals = hostGoals;
        this.guestTeam = guestTeam;
        this.guestGoals = guestGoals;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public League getMatchType() {
        return matchType;
    }

    public void setMatchType(League matchType) {
        this.matchType = matchType;
    }

    public Clubs getHostTeam() {
        return hostTeam;
    }

    public void setHostTeam(Clubs hostTeam) {
        this.hostTeam = hostTeam;
    }

    public int getHostGoals() {
        return hostGoals;
    }

    public void setHostGoals(int hostGoals) {
        this.hostGoals = hostGoals;
    }

    public Clubs getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(Clubs guestTeam) {
        this.guestTeam = guestTeam;
    }

    public int getGuestGoals() {
        return guestGoals;
    }

    public void setGuestGoals(int guestGoals) {
        this.guestGoals = guestGoals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballMatches that = (FootballMatches) o;
        return matchId == that.matchId && hostGoals == that.hostGoals && guestGoals == that.guestGoals && matchType.equals(that.matchType) && hostTeam.equals(that.hostTeam) && guestTeam.equals(that.guestTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, matchType, hostTeam, hostGoals, guestTeam, guestGoals);
    }

    @Override
    public String toString() {
        return "FootballMatches{" +
                "matchId=" + matchId +
                ", matchType=" + matchType +
                ", hostTeam=" + hostTeam +
                ", hostGoals=" + hostGoals +
                ", guestTeam=" + guestTeam +
                ", guestGoals=" + guestGoals +
                '}';
    }
}
