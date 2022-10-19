package com.alireza.repository;

import com.alireza.repository.configuration.DatabaseConnection;
import com.alireza.model.Clubs;
import com.alireza.model.FootballMatches;
import com.alireza.model.FootballTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FootballRepository {
    private static final String ADD_CLUB_QUERY = "insert into football_tbl(club_name) values (?)";
    private static final String DELETE_CLUB_QUERY = "delete from football_tbl where club_name = ?";


    private static final String WIN_HOST_TEAM_QUERY = "update football_tbl set number_of_matches = number_of_matches + 1, win = win + 1, goals_scored = goals_scored + ?, " +
            "goals_received = goals_received + ?, goals_difference = goals_difference + ?, point = point + 3 " +
            "where club_name = ?";
    private static final String LOST_GUEST_TEAM_QUERY = "update football_tbl set number_of_matches = number_of_matches + 1, lost = lost + 1, goals_scored = goals_scored + ?, " +
            "goals_received = goals_received + ?, goals_difference = goals_difference + ? where club_name = ?";


    private static final String LOST_HOST_TEAM_QUERY = "update football_tbl set number_of_matches = number_of_matches + 1, lost = lost + 1, goals_scored = goals_scored + ?, " +
            "goals_received = goals_received + ?, goals_difference = goals_difference + ? where club_name = ?";
    private static final String WIN_GUEST_TEAM_QUERY = "update football_tbl set number_of_matches = number_of_matches + 1, win = win + 1, goals_scored = goals_scored + ?, " +
            "goals_received = goals_received + ?, goals_difference = goals_difference + ?, point = point + 3 " +
            "where club_name = ?";


    private static final String DRAW_QUERY = "update football_tbl set number_of_matches = number_of_matches + 1, draw = draw + 1, goals_scored = goals_scored + ?, " +
            "goals_received = goals_received + ?, point = point + 1 " +
            "where club_name = ? or club_name = ?";


    private static final String SELECT_TEAM_QUERY = "select * from football_tbl where club_name = ?";
    private static final String SHOW_FOOTBALL_TABLE_QUERY = "select * from football_tbl order by point desc";

    public static void addClubToLeague(Clubs club){
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CLUB_QUERY);
            preparedStatement.setString(1, club.getName());

            preparedStatement.execute();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void deleteClubFromLeague(Clubs club) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLUB_QUERY);
            preparedStatement.setString(1, club.getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void winHostTeam(FootballMatches footballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(WIN_HOST_TEAM_QUERY);
            preparedStatement.setInt(1, footballMatches.getHostGoals());
            preparedStatement.setInt(2, footballMatches.getGuestGoals());
            preparedStatement.setInt(3, footballMatches.getHostGoals() - footballMatches.getGuestGoals());
            preparedStatement.setString(4, footballMatches.getHostTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void lostGuestTeam(FootballMatches footballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(LOST_GUEST_TEAM_QUERY);
            preparedStatement.setInt(1, footballMatches.getGuestGoals());
            preparedStatement.setInt(2, footballMatches.getHostGoals());
            preparedStatement.setInt(3, footballMatches.getGuestGoals() - footballMatches.getHostGoals());
            preparedStatement.setString(4, footballMatches.getGuestTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void lostHostTeam(FootballMatches footballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(LOST_HOST_TEAM_QUERY);
            preparedStatement.setInt(1, footballMatches.getHostGoals());
            preparedStatement.setInt(2, footballMatches.getGuestGoals());
            preparedStatement.setInt(3, footballMatches.getHostGoals() - footballMatches.getGuestGoals());
            preparedStatement.setString(4, footballMatches.getHostTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void winGuestTeam(FootballMatches footballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(WIN_GUEST_TEAM_QUERY);
            preparedStatement.setInt(1, footballMatches.getGuestGoals());
            preparedStatement.setInt(2, footballMatches.getHostGoals());
            preparedStatement.setInt(3, footballMatches.getGuestGoals() - footballMatches.getHostGoals());
            preparedStatement.setString(4, footballMatches.getGuestTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void draw(FootballMatches footballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(DRAW_QUERY);
            preparedStatement.setInt(1, footballMatches.getHostGoals());
            preparedStatement.setInt(2, footballMatches.getGuestGoals());
            preparedStatement.setString(3, footballMatches.getHostTeam().getName());
            preparedStatement.setString(4, footballMatches.getGuestTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static String showClubDetail(Clubs clubs) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEAM_QUERY);
            preparedStatement.setString(1, clubs.getName());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FootballTable footballTable = new FootballTable();
                footballTable.setClubName(new Clubs(resultSet.getString(1)));
                footballTable.setNumberOfMatches(resultSet.getInt(2));
                footballTable.setWin(resultSet.getInt(3));
                footballTable.setDraw(resultSet.getInt(4));
                footballTable.setLost(resultSet.getInt(5));
                footballTable.setGoalsScored(resultSet.getInt(6));
                footballTable.setGoalsReceived(resultSet.getInt(7));
                footballTable.setGoalsDifference(resultSet.getInt(8));
                footballTable.setPoint(resultSet.getInt(9));
                return footballTable.toString();
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (
                SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        return null;
    }
    public static List<FootballTable> showFootballTable() {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_FOOTBALL_TABLE_QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<FootballTable> footballTablesList = new ArrayList<>();
            while (resultSet.next()) {
                FootballTable footballTable = new FootballTable();
                footballTable.setClubName(new Clubs(resultSet.getString(1)));
                footballTable.setNumberOfMatches(resultSet.getInt(2));
                footballTable.setWin(resultSet.getInt(3));
                footballTable.setDraw(resultSet.getInt(4));
                footballTable.setLost(resultSet.getInt(5));
                footballTable.setGoalsScored(resultSet.getInt(6));
                footballTable.setGoalsReceived(resultSet.getInt(7));
                footballTable.setGoalsDifference(resultSet.getInt(8));
                footballTable.setPoint(resultSet.getInt(9));
                footballTablesList.add(footballTable);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return footballTablesList;

        } catch (
                SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        return null;
    }
}
