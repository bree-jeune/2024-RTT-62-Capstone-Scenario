package dao;

import org.example.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserScenarioDAO {

    public void addUserScenario(models.UserScenario userScenario) {
        String query = "INSERT INTO UserScenarios (user_id, scenario_id, team_lead, status, score, attempted_at, completed_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userScenario.getUserId());
            preparedStatement.setInt(2, userScenario.getScenarioId());
            preparedStatement.setBoolean(3, userScenario.isTeamLead());
            preparedStatement.setString(4, userScenario.getStatus());
            preparedStatement.setDouble(5, userScenario.getScore());
            preparedStatement.setTimestamp(6, userScenario.getAttemptedAt());
            preparedStatement.setTimestamp(7, userScenario.getCompletedAt());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<models.UserScenario> getAllUserScenarios() {
        List<models.UserScenario> userScenarios = new ArrayList<>();
        String query = "SELECT * FROM UserScenarios";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                models.UserScenario userScenario = new models.UserScenario();
                userScenario.setUserScenarioId(resultSet.getInt("user_scenario_id"));
                userScenario.setUserId(resultSet.getInt("user_id"));
                userScenario.setScenarioId(resultSet.getInt("scenario_id"));
                userScenario.setTeamLead(resultSet.getBoolean("team_lead"));
                userScenario.setStatus(resultSet.getString("status"));
                userScenario.setScore(resultSet.getDouble("score"));
                userScenario.setAttemptedAt(resultSet.getTimestamp("attempted_at"));
                userScenario.setCompletedAt(resultSet.getTimestamp("completed_at"));
                userScenarios.add(userScenario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userScenarios;
    }

    public models.UserScenario getUserScenarioById(int userScenarioId) {
        models.UserScenario userScenario = null;
        String query = "SELECT * FROM UserScenarios WHERE user_scenario_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userScenarioId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    userScenario = new models.UserScenario();
                    userScenario.setUserScenarioId(resultSet.getInt("user_scenario_id"));
                    userScenario.setUserId(resultSet.getInt("user_id"));
                    userScenario.setScenarioId(resultSet.getInt("scenario_id"));
                    userScenario.setTeamLead(resultSet.getBoolean("team_lead"));
                    userScenario.setStatus(resultSet.getString("status"));
                    userScenario.setScore(resultSet.getDouble("score"));
                    userScenario.setAttemptedAt(resultSet.getTimestamp("attempted_at"));
                    userScenario.setCompletedAt(resultSet.getTimestamp("completed_at"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userScenario;
    }

    public void updateUserScenario(models.UserScenario userScenario) {
        String query = "UPDATE UserScenarios SET user_id = ?, scenario_id = ?, team_lead = ?, status = ?, score = ?, attempted_at = ?, completed_at = ? WHERE user_scenario_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userScenario.getUserId());
            preparedStatement.setInt(2, userScenario.getScenarioId());
            preparedStatement.setBoolean(3, userScenario.isTeamLead());
            preparedStatement.setString(4, userScenario.getStatus());
            preparedStatement.setDouble(5, userScenario.getScore());
            preparedStatement.setTimestamp(6, userScenario.getAttemptedAt());
            preparedStatement.setTimestamp(7, userScenario.getCompletedAt());
            preparedStatement.setInt(8, userScenario.getUserScenarioId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserScenario(int userScenarioId) {
        String query = "DELETE FROM UserScenarios WHERE user_scenario_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userScenarioId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

