package com.alireza.model;

import java.util.Objects;

public class VolleyballMatches {
    private int matchId;
    private League matchType;
    private Clubs hostTeam;
    private int hostSets;
    private Clubs guestTeam;
    private int guestSets;

    public VolleyballMatches(League matchType, Clubs hostTeam, int hostSets, Clubs guestTeam, int guestSets) {
        this.matchType = matchType;
        this.hostTeam = hostTeam;
        this.hostSets = hostSets;
        this.guestTeam = guestTeam;
        this.guestSets = guestSets;
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

    public int getHostSets() {
        return hostSets;
    }

    public void setHostSets(int hostSets) {
        this.hostSets = hostSets;
    }

    public Clubs getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(Clubs guestTeam) {
        this.guestTeam = guestTeam;
    }

    public int getGuestSets() {
        return guestSets;
    }

    public void setGuestSets(int guestSets) {
        this.guestSets = guestSets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VolleyballMatches that = (VolleyballMatches) o;
        return matchId == that.matchId && hostSets == that.hostSets && guestSets == that.guestSets && matchType.equals(that.matchType) && hostTeam.equals(that.hostTeam) && guestTeam.equals(that.guestTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, matchType, hostTeam, hostSets, guestTeam, guestSets);
    }

    @Override
    public String toString() {
        return "VolleyballMatches{" +
                "matchId=" + matchId +
                ", matchType=" + matchType +
                ", hostTeam=" + hostTeam +
                ", hostSets=" + hostSets +
                ", guestTeam=" + guestTeam +
                ", guestSets=" + guestSets +
                '}';
    }
}
