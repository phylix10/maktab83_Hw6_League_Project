package com.alireza.repository;

import com.alireza.repository.configuration.DatabaseConnection;
import com.alireza.model.Clubs;
import com.alireza.model.League;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClubRepository {
    public static final String CREATE_CLUB_QUERY = "insert into clubs(league_type, name, coach, stadium, number_of_player, number_of_cups) " +
            "values(?, ?, ?, ?, ?, ?)";
    private static final String SELECT_FOOTBALL_CLUB_QUERY = "select * from clubs c join league_tbl lt on lt.type = c.league_type " +
            "where c.league_type = 'football' and c.name = ?";
    private static final String DELETE_FOOTBALL_CLUB_QUERY = "delete from clubs where name = ? and league_type = 'football' ";
    private static final String SELECT_VOLLEYBALL_CLUB_QUERY = "select * from clubs c join league_tbl lt on lt.type = c.league_type " +
            "where c.league_type = 'volleyball' and c.name = ?";
    private static final String DELETE_VOLLEYBALL_CLUB_QUERY = "delete from clubs where name = ? and league_type = 'volleyball' ";

    public static void createClub(Clubs club){
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CLUB_QUERY);
            preparedStatement.setString(1, club.getLeagueType().getType());
            preparedStatement.setString(2, club.getName());
            preparedStatement.setString(3, club.getCoach());
            preparedStatement.setString(4, club.getStadium());
            preparedStatement.setInt(5, club.getNumberOfPlayer());
            preparedStatement.setInt(6, club.getNumberOfCups());

            preparedStatement.execute();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static Clubs findFootballClub(Clubs club) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FOOTBALL_CLUB_QUERY);
            preparedStatement.setString(1, club.getName());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                League league = new League(resultSet.getString(7), resultSet.getString(8));
                String name = resultSet.getString(2);
                String coach = resultSet.getString(3);
                String stadium = resultSet.getString(4);
                int numberOfPlayer = resultSet.getInt(5);
                int numberOfCups = resultSet.getInt(6);
                return new Clubs(league, name, coach, stadium, numberOfPlayer, numberOfCups);
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
    public static void deleteFootballClub(Clubs club) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FOOTBALL_CLUB_QUERY);
            preparedStatement.setString(1,club.getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static Clubs findVolleyballClub(Clubs club) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VOLLEYBALL_CLUB_QUERY);
            preparedStatement.setString(1, club.getName());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                League league = new League(resultSet.getString(7), resultSet.getString(8));
                String name = resultSet.getString(2);
                String coach = resultSet.getString(3);
                String stadium = resultSet.getString(4);
                int numberOfPlayer = resultSet.getInt(5);
                int numberOfCups = resultSet.getInt(6);
                return new Clubs(league, name, coach, stadium, numberOfPlayer, numberOfCups);
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
    public static void deleteVolleyballClub(Clubs club) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_VOLLEYBALL_CLUB_QUERY);
            preparedStatement.setString(1,club.getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
}
