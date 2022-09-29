package com.alireza.model;

import java.util.Objects;

public class FootballTable {
    private Clubs clubName;
    private int numberOfMatches;
    private int win;
    private int draw;
    private int lost;
    private int goalsScored;
    private int goalsReceived;
    private int goalsDifference;
    private int point;

    public FootballTable() {
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

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public int getGoalsDifference() {
        return goalsDifference;
    }

    public void setGoalsDifference(int goalsDifference) {
        this.goalsDifference = goalsDifference;
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
        FootballTable that = (FootballTable) o;
        return numberOfMatches == that.numberOfMatches && win == that.win && draw == that.draw && lost == that.lost && goalsScored == that.goalsScored && goalsReceived == that.goalsReceived && goalsDifference == that.goalsDifference && point == that.point && clubName.equals(that.clubName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubName, numberOfMatches, win, draw, lost, goalsScored, goalsReceived, goalsDifference, point);
    }

    @Override
    public String toString() {
        return clubName.getName() +
                "| matches: " + numberOfMatches +
                "| win: " + win +
                "| draw: " + draw +
                "| lost: " + lost +
                "| goalScored: " + goalsScored +
                "| goalReceived: " + goalsReceived +
                "| goalDifference: " + goalsDifference +
                "| point: " + point;
    }
}
