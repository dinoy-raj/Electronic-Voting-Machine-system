package database;

import java.sql.*;

public class MySQL {
    String username = "root";
    String password = "9645682830";
    String dbName = "VotR";
    String url = "jdbc:mysql://localhost:3306/";
    Connection connection;

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

    public void insertIntoElection(int ID, String name) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO ELECTION VALUES(" + ID + ", " + "'" + name + "'" + ");");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}