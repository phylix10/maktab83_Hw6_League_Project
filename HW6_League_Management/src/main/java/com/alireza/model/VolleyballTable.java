package com.alireza.model;

import java.util.Objects;

public class VolleyballTable {
    private Clubs clubName;
    private int numberOfMatches;
    private int win;
    private int lost;
    private int winSets;
    private int lostSets;
    private int point;

    public VolleyballTable() {
    }

    public Clubs getClubName() {
        return clubName;
    }

    public void setClubName(Clubs clubName) {
        this.clubName = clubName;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public void setNumberOfMatches(int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getWinSets() {
        return winSets;
    }

    public void setWinSets(int winSets) {
        this.winSets = winSets;
    }

    public int getLostSets() {
        return lostSets;
    }

    public void setLostSets(int lostSets) {
        this.lostSets = lostSets;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VolleyballTable that = (VolleyballTable) o;
        return numberOfMatches == that.numberOfMatches && win == that.win && lost == that.lost && winSets == that.winSets && lostSets == that.lostSets && point == that.point && clubName.equals(that.clubName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubName, numberOfMatches, win, lost, winSets, lostSets, point);
    }

    @Override
    public String toString() {
        return  clubName.getName() +
                "| Matches: " + numberOfMatches +
                "| win: " + win +
                "| lost: " + lost +
                "| winSets: " + winSets +
                "| lostSets: " + lostSets +
                "| point: " + point;
    }
}
