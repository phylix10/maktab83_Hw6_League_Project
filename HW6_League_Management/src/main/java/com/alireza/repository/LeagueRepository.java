package com.alireza.repository;

import com.alireza.configuration.DatabaseConnection;
import com.alireza.model.League;

import java.sql.*;

public class LeagueRepository {
    private static final String ADD_LEAGUE_QUERY = "insert into league_tbl(name, type) values (?, ?)";
    private static final String SELECT_LEAGUE_QUERY = "select * from league_tbl where name = ? and type = ?";

    public static void addLeague(League league){
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_LEAGUE_QUERY);
            preparedStatement.setString(1, league.getName());
            preparedStatement.setString(2, league.getType());

            preparedStatement.execute();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static League findLeague(League league) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LEAGUE_QUERY);
            preparedStatement.setString(1, league.getName());
            preparedStatement.setString(2, league.getType());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String type = resultSet.getString(2);
                return new League(name, type);
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
}
