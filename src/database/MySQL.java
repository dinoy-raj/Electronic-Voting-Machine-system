package database;

import java.sql.*;

public class MySQL {
    String username = "root";
    String password = "9645682830";
    String dbName = "VotR";
    String url = "jdbc:mysql://localhost:3306/";
    Connection connection;
    private ResultSet rs;

    public void connectJDBC() {
        try {
            connection = DriverManager.getConnection(url + dbName, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retrieveData(String table) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + ";");

            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.println(", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addElection(String ID, String name, boolean isStarted) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO ELECTIONS VALUES('" + ID + "', " + "'" + name + "', " + isStarted + ");");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void addPost(String ID, String election_id, String name) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO POSTS VALUES('" + ID + "', " + "'" + election_id + "', '" + name + "');");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void addCandidate(String ID, String post_id, String voter_id, int count) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO CANDIDATES VALUES('" + ID + "', '" + post_id + "', '" + voter_id + "', " + count + ");");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void addVoter(String ID, String name, String gender, String address, String pinCode, String phone) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO VOTERS VALUES('" + ID + "', " + "'" + name + "', '" + gender + "', '" + address + "',  '" + pinCode + "', '" + phone + "');");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void addResult(String electionID, String winnerID) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO RESULTS VALUES('" + electionID + "', '" + winnerID + "');");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void addEligibleVoter(String electionID, String voterID, String password) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO ELIGIBLE_VOTERS VALUES('" + electionID + "', " + "'" + voterID + "', '" + password + "');");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void test() {

    }
}