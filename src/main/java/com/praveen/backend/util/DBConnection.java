package com.praveen.backend.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/workflow_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create and return the database connection
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }

        return null;
    }

    // Main method to test the database connection
    public static void main(String[] args) {

        Connection connection = getConnection();

        if (connection != null) {
            System.out.println("==================================");
            System.out.println(" Database Connected Successfully!");
            System.out.println("==================================");

            try {
                connection.close();
                System.out.println("Database Connection Closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("==================================");
            System.out.println(" Database Connection Failed!");
            System.out.println("==================================");
        }
    }
}