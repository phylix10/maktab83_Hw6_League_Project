package com.alireza.repository;

import com.alireza.repository.configuration.DatabaseConnection;
import com.alireza.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VolleyballRepository {
    private static final String ADD_CLUB_QUERY = "insert into volleyball_tbl(club_name) values (?)";
    private static final String DELETE_CLUB_QUERY = "delete from volleyball_tbl where club_name = ?";

    private static final String WIN_HOST_TEAM_3_0_QUERY = "update volleyball_tbl set number_of_matches = number_of_matches + 1, win = win + 1, win_sets = win_sets + ?, " +
            "point = point + 3 where club_name = ?";
    private static final String LOST_GUEST_TEAM_0_3_QUERY = "update volleyball_tbl set number_of_matches = number_of_matches + 1, lost = lost + 1, lost_sets = lost_sets + ? " +
            "where club_name = ?";

    private static final String WIN_HOST_TEAM_3_1_QUERY = "update volleyball_tbl set number_of_matches = number_of_matches + 1, win = win + 1, win_sets = win_sets + ?, " +
            "lost_sets = lost_sets + ?, point = point + 3 where club_name = ?";
    private static final String LOST_GUEST_TEAM_1_3_QUERY = "update volleyball_tbl set number_of_matches = number_of_matches + 1, lost = lost + 1, win_sets = win_sets + ?, " +
            "lost_sets = lost_sets + ? where club_name = ?";

    private static final String WIN_HOST_TEAM_3_2_QUERY = "update volleyball_tbl set number_of_matches = number_of_matches + 1, win = win + 1, win_sets = win_sets + ?, " +
            "lost_sets = lost_sets + ?, point = point + 2 where club_name = ?";
    private static final String LOST_GUEST_TEAM_2_3_QUERY = "update volleyball_tbl set number_of_matches = number_of_matches + 1, lost = lost + 1, win_sets = win_sets + ?, " +
            "lost_sets = lost_sets + ?, point = point + 1 where club_name = ?";

    private static final String WIN_GUEST_TEAM_3_0_QUERY = "update volleyball_tbl set number_of_matches = number_of_matches + 1, win = win + 1, win_sets = win_sets + ?, " +
            "point = point + 3 where club_name = ?";
    private static final String LOST_HOST_TEAM_0_3_QUERY = "update volleyball_tbl set number_of_matches = number_of_matches + 1, lost = lost + 1, lost_sets = lost_sets + ? " +
            "where club_name = ?";

    private static final String WIN_GUEST_TEAM_3_1_QUERY = "update volleyball_tbl set number_of_matches = number_of_matches + 1, win = win + 1, win_sets = win_sets + ?, " +
            "lost_sets = lost_sets + ?, point = point + 3 where club_name = ?";
    private static final String LOST_HOST_TEAM_1_3_QUERY = "update volleyball_tbl set number_of_matches = number_of_matches + 1, lost = lost + 1, win_sets = win_sets + ?, " +
            "lost_sets = lost_sets + ? where club_name = ?";

    private static final String WIN_GUEST_TEAM_3_2_QUERY = "update volleyball_tbl set number_of_matches = number_of_matches + 1, win = win + 1, win_sets = win_sets + ?, " +
            "lost_sets = lost_sets + ?, point = point + 2 where club_name = ?";
    private static final String LOST_HOST_TEAM_2_3_QUERY = "update volleyball_tbl set number_of_matches = number_of_matches + 1, lost = lost + 1, win_sets = win_sets + ?, " +
            "lost_sets = lost_sets + ?, point = point + 1 where club_name = ?";

    private static final String SELECT_TEAM_QUERY = "select * from volleyball_tbl where club_name = ?";
    private static final String SHOW_VOLLEYBALL_TABLE_QUERY = "select * from volleyball_tbl order by point desc";

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
    public static void winHost3Guest0(VolleyballMatches volleyballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(WIN_HOST_TEAM_3_0_QUERY);
            preparedStatement.setInt(1, volleyballMatches.getHostSets());
            preparedStatement.setString(2, volleyballMatches.getHostTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void winHost3Guest1(VolleyballMatches volleyballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(WIN_HOST_TEAM_3_1_QUERY);
            preparedStatement.setInt(1, volleyballMatches.getHostSets());
            preparedStatement.setInt(2, volleyballMatches.getGuestSets());
            preparedStatement.setString(3, volleyballMatches.getHostTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void winHost3Guest2(VolleyballMatches volleyballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(WIN_HOST_TEAM_3_2_QUERY);
            preparedStatement.setInt(1, volleyballMatches.getHostSets());
            preparedStatement.setInt(2, volleyballMatches.getGuestSets());
            preparedStatement.setString(3, volleyballMatches.getHostTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void lostGuest0Host3(VolleyballMatches volleyballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(LOST_GUEST_TEAM_0_3_QUERY);
            preparedStatement.setInt(1, volleyballMatches.getHostSets());
            preparedStatement.setString(2, volleyballMatches.getGuestTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void lostGuest1Host3(VolleyballMatches volleyballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(LOST_GUEST_TEAM_1_3_QUERY);
            preparedStatement.setInt(1, volleyballMatches.getGuestSets());
            preparedStatement.setInt(2, volleyballMatches.getHostSets());
            preparedStatement.setString(3, volleyballMatches.getGuestTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void lostGuest2Host3(VolleyballMatches volleyballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(LOST_GUEST_TEAM_2_3_QUERY);
            preparedStatement.setInt(1, volleyballMatches.getGuestSets());
            preparedStatement.setInt(2, volleyballMatches.getHostSets());
            preparedStatement.setString(3, volleyballMatches.getGuestTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void winGuest3Host0(VolleyballMatches volleyballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(WIN_GUEST_TEAM_3_0_QUERY);
            preparedStatement.setInt(1, volleyballMatches.getGuestSets());
            preparedStatement.setString(2, volleyballMatches.getGuestTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void winGuest3Host1(VolleyballMatches volleyballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(WIN_GUEST_TEAM_3_1_QUERY);
            preparedStatement.setInt(1, volleyballMatches.getGuestSets());
            preparedStatement.setInt(2, volleyballMatches.getHostSets());
            preparedStatement.setString(3, volleyballMatches.getGuestTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void winGuest3Host2(VolleyballMatches volleyballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(WIN_GUEST_TEAM_3_2_QUERY);
            preparedStatement.setInt(1, volleyballMatches.getGuestSets());
            preparedStatement.setInt(2, volleyballMatches.getHostSets());
            preparedStatement.setString(3, volleyballMatches.getGuestTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void lostHost0Guest3(VolleyballMatches volleyballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(LOST_HOST_TEAM_0_3_QUERY);
            preparedStatement.setInt(1, volleyballMatches.getGuestSets());
            preparedStatement.setString(2, volleyballMatches.getHostTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void lostHost1Guest3(VolleyballMatches volleyballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(LOST_HOST_TEAM_1_3_QUERY);
            preparedStatement.setInt(1, volleyballMatches.getHostSets());
            preparedStatement.setInt(2, volleyballMatches.getGuestSets());
            preparedStatement.setString(3, volleyballMatches.getHostTeam().getName());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    public static void lostHost2Guest3(VolleyballMatches volleyballMatches) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(LOST_HOST_TEAM_2_3_QUERY);
            preparedStatement.setInt(1, volleyballMatches.getHostSets());
            preparedStatement.setInt(2, volleyballMatches.getGuestSets());
            preparedStatement.setString(3, volleyballMatches.getHostTeam().getName());

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
                VolleyballTable volleyballTable = new VolleyballTable();
                volleyballTable.setClubName(new Clubs(resultSet.getString(1)));
                volleyballTable.setNumberOfMatches(resultSet.getInt(2));
                volleyballTable.setWin(resultSet.getInt(3));
                volleyballTable.setLost(resultSet.getInt(4));
                volleyballTable.setWinSets(resultSet.getInt(5));
                volleyballTable.setLostSets(resultSet.getInt(6));
                volleyballTable.setPoint(resultSet.getInt(7));
                return volleyballTable.toString();
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
    public static List<VolleyballTable> showVolleyballTable() {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_VOLLEYBALL_TABLE_QUERY);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<VolleyballTable> volleyballTableList = new ArrayList<>();
            while (resultSet.next()) {
                VolleyballTable volleyballTable = new VolleyballTable();
                volleyballTable.setClubName(new Clubs(resultSet.getString(1)));
                volleyballTable.setNumberOfMatches(resultSet.getInt(2));
                volleyballTable.setWin(resultSet.getInt(3));
                volleyballTable.setLost(resultSet.getInt(4));
                volleyballTable.setWinSets(resultSet.getInt(5));
                volleyballTable.setLostSets(resultSet.getInt(6));
                volleyballTable.setPoint(resultSet.getInt(7));
                volleyballTableList.add(volleyballTable);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return volleyballTableList;

        } catch (
                SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        return null;
    }
}
