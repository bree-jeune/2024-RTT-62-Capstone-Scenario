package dao;
import models.Feedback;
import org.example.DatabaseConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {

    public void addFeedback(Feedback feedback) {
        String query = "INSERT INTO Feedback (user_scenario_id, feedback_text, created_at, created_by, updated_at, updated_by) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, feedback.getUserScenarioId());
            preparedStatement.setString(2, feedback.getFeedbackText());
            preparedStatement.setTimestamp(3, feedback.getCreatedAt());
            preparedStatement.setInt(4, feedback.getCreatedBy());
            preparedStatement.setTimestamp(5, feedback.getUpdatedAt());
            preparedStatement.setInt(6, feedback.getUpdatedBy());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Feedback> getAllFeedbacks() {
        List<Feedback> feedbacks = new ArrayList<>();
        String query = "SELECT * FROM Feedback";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Feedback feedback = new Feedback();
                feedback.setFeedbackId(resultSet.getInt("feedback_id"));
                feedback.setUserScenarioId(resultSet.getInt("user_scenario_id"));
                feedback.setFeedbackText(resultSet.getString("feedback_text"));
                feedback.setCreatedAt(resultSet.getTimestamp("created_at"));
                feedback.setCreatedBy(resultSet.getInt("created_by"));
                feedback.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                feedback.setUpdatedBy(resultSet.getInt("updated_by"));
                feedbacks.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }

    public Feedback getFeedbackById(int feedbackId) {
        Feedback feedback = null;
        String query = "SELECT * FROM Feedback WHERE feedback_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, feedbackId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    feedback = new Feedback();
                    feedback.setFeedbackId(resultSet.getInt("feedback_id"));
                    feedback.setUserScenarioId(resultSet.getInt("user_scenario_id"));
                    feedback.setFeedbackText(resultSet.getString("feedback_text"));
                    feedback.setCreatedAt(resultSet.getTimestamp("created_at"));
                    feedback.setCreatedBy(resultSet.getInt("created_by"));
                    feedback.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                    feedback.setUpdatedBy(resultSet.getInt("updated_by"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedback;
    }

    public void updateFeedback(Feedback feedback) {
        String query = "UPDATE Feedback SET user_scenario_id = ?, feedback_text = ?, created_at = ?, created_by = ?, updated_at = ?, updated_by = ? WHERE feedback_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, feedback.getUserScenarioId());
            preparedStatement.setString(2, feedback.getFeedbackText());
            preparedStatement.setTimestamp(3, feedback.getCreatedAt());
            preparedStatement.setInt(4, feedback.getCreatedBy());
            preparedStatement.setTimestamp(5, feedback.getUpdatedAt());
            preparedStatement.setInt(6, feedback.getUpdatedBy());
            preparedStatement.setInt(7, feedback.getFeedbackId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFeedback(int feedbackId) {
        String query = "DELETE FROM Feedback WHERE feedback_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, feedbackId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
