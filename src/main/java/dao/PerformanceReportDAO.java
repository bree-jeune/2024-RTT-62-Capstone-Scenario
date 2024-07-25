package dao;

import models.PerformanceReport;
import org.example.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PerformanceReportDAO {

    public void addPerformanceReport(PerformanceReport performanceReport) {
        String query = "INSERT INTO PerformanceReports (user_id, generated_at, report_data) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, performanceReport.getUserId());
            preparedStatement.setTimestamp(2, performanceReport.getGeneratedAt());
            preparedStatement.setString(3, performanceReport.getReportData());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PerformanceReport> getAllPerformanceReports() {
        List<PerformanceReport> performanceReports = new ArrayList<>();
        String query = "SELECT * FROM PerformanceReports";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                PerformanceReport performanceReport = new PerformanceReport();
                performanceReport.setReportId(resultSet.getInt("report_id"));
                performanceReport.setUserId(resultSet.getInt("user_id"));
                performanceReport.setGeneratedAt(resultSet.getTimestamp("generated_at"));
                performanceReport.setReportData(resultSet.getString("report_data"));
                performanceReports.add(performanceReport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return performanceReports;
    }

    public PerformanceReport getPerformanceReportById(int reportId) {
        PerformanceReport performanceReport = null;
        String query = "SELECT * FROM PerformanceReports WHERE report_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, reportId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    performanceReport = new PerformanceReport();
                    performanceReport.setReportId(resultSet.getInt("report_id"));
                    performanceReport.setUserId(resultSet.getInt("user_id"));
                    performanceReport.setGeneratedAt(resultSet.getTimestamp("generated_at"));
                    performanceReport.setReportData(resultSet.getString("report_data"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return performanceReport;
    }

    public void updatePerformanceReport(PerformanceReport performanceReport) {
        String query = "UPDATE PerformanceReports SET user_id = ?, generated_at = ?, report_data = ? WHERE report_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, performanceReport.getUserId());
            preparedStatement.setTimestamp(2, performanceReport.getGeneratedAt());
            preparedStatement.setString(3, performanceReport.getReportData());
            preparedStatement.setInt(4, performanceReport.getReportId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePerformanceReport(int reportId) {
        String query = "DELETE FROM PerformanceReports WHERE report_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, reportId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
