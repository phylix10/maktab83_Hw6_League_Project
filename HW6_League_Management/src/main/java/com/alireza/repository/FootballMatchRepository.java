package com.alireza.repository;

import com.alireza.repository.configuration.DatabaseConnection;
import com.alireza.model.FootballMatches;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FootballMatchRepository {
    private static final String DO_MATCH_QUERY = "insert into football_match(match_type, host_team, host_goals, guest_team, guest_goals) " +
            "values (?, ?, ?, ?, ?) returning match_id";

    public static void doMatch(FootballMatches footballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(DO_MATCH_QUERY);
            preparedStatement.setString(1, footballMatches.getMatchType().getType());
            preparedStatement.setString(2, footballMatches.getHostTeam().getName());
            preparedStatement.setInt(3, footballMatches.getHostGoals());
            preparedStatement.setString(4, footballMatches.getGuestTeam().getName());
            preparedStatement.setInt(5, footballMatches.getGuestGoals());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("match_id");
            footballMatches.setMatchId(id);

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
}
