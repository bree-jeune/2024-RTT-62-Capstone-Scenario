package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnect {

    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/scenario_repository";
        String username = "root";
        String password = "bullock";

        // Connection and statement
        Connection connection = null;
        Statement statement = null;

        // FileWriter to write CSV file
        FileWriter fileWriter = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            statement = connection.createStatement();

            // Execute a query
            String query = "SELECT * FROM PerformanceReports";
            ResultSet resultSet = statement.executeQuery(query);

            // Open CSV file for writing
            fileWriter = new FileWriter("performance_reports.csv");

            // Write header row
            fileWriter.append("report_id,user_id,generated_at,report_data\n");

            // Write data rows
            while (resultSet.next()) {
                fileWriter.append(resultSet.getInt("report_id") + ",");
                fileWriter.append(resultSet.getInt("user_id") + ",");
                fileWriter.append(resultSet.getTimestamp("generated_at") + ",");
                fileWriter.append(resultSet.getString("report_data") + "\n");
            }

            // Close the result set
            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the statement
                if (statement != null) {
                    statement.close();
                }

                // Close the connection
                if (connection != null) {
                    connection.close();
                }

                // Close the file writer
                if (fileWriter != null) {
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
