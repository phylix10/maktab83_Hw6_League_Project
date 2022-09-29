package com.alireza.repository;

import com.alireza.configuration.DatabaseConnection;
import com.alireza.model.VolleyballMatches;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VolleyballMatchRepository {
    private static final String DO_MATCH_QUERY = "insert into volleyball_match(match_type, host_team, host_sets, guest_team, guest_sets) " +
            "values (?, ?, ?, ?, ?) returning match_id";

    public static void doMatch(VolleyballMatches volleyballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(DO_MATCH_QUERY);
            preparedStatement.setString(1, volleyballMatches.getMatchType().getType());
            preparedStatement.setString(2, volleyballMatches.getHostTeam().getName());
            preparedStatement.setInt(3, volleyballMatches.getHostSets());
            preparedStatement.setString(4, volleyballMatches.getGuestTeam().getName());
            preparedStatement.setInt(5, volleyballMatches.getGuestSets());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("match_id");
            volleyballMatches.setMatchId(id);

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
}
