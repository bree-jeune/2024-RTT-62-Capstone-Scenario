package dao;
import org.example.DatabaseConnection;
import models.Scenario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScenarioDAO {
    public void addScenario(Scenario scenario) {
        String query = "INSERT INTO Scenarios (title, description, keywords, objectives, competencies_assessed, created_by, updated_by, version, scenario_level, difficulty_level, semester_level, patient_type, body_system_topic, mci_selection, fidelity_level) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, scenario.getTitle());
            preparedStatement.setString(2, scenario.getDescription());
            preparedStatement.setString(3, scenario.getKeywords());
            preparedStatement.setString(4, scenario.getObjectives());
            preparedStatement.setString(5, scenario.getCompetenciesAssessed());
            preparedStatement.setInt(6, scenario.getCreatedBy());
            preparedStatement.setInt(7, scenario.getUpdatedBy());
            preparedStatement.setInt(8, scenario.getVersion());
            preparedStatement.setString(9, scenario.getScenarioLevel());
            preparedStatement.setString(10, scenario.getDifficultyLevel());
            preparedStatement.setString(11, scenario.getSemesterLevel());
            preparedStatement.setString(12, scenario.getPatientType());
            preparedStatement.setString(13, scenario.getBodySystemTopic());
            preparedStatement.setString(14, scenario.getMciSelection());
            preparedStatement.setString(15, scenario.getFidelityLevel());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Scenario> getAllScenarios() {
        List<Scenario> scenarios = new ArrayList<>();
        String query = "SELECT * FROM Scenarios";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Scenario scenario = new Scenario();
                scenario.setScenarioId(resultSet.getInt("scenario_id"));
                scenario.setTitle(resultSet.getString("title"));
                scenario.setDescription(resultSet.getString("description"));
                scenario.setKeywords(resultSet.getString("keywords"));
                scenario.setObjectives(resultSet.getString("objectives"));
                scenario.setCompetenciesAssessed(resultSet.getString("competencies_assessed"));
                scenario.setCreatedBy(resultSet.getInt("created_by"));
                scenario.setUpdatedBy(resultSet.getInt("updated_by"));
                scenario.setCreatedAt(resultSet.getTimestamp("created_at"));
                scenario.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                scenario.setVersion(resultSet.getInt("version"));
                scenario.setScenarioLevel(resultSet.getString("scenario_level"));
                scenario.setDifficultyLevel(resultSet.getString("difficulty_level"));
                scenario.setSemesterLevel(resultSet.getString("semester_level"));
                scenario.setPatientType(resultSet.getString("patient_type"));
                scenario.setBodySystemTopic(resultSet.getString("body_system_topic"));
                scenario.setMciSelection(resultSet.getString("mci_selection"));
                scenario.setFidelityLevel(resultSet.getString("fidelity_level"));
                scenarios.add(scenario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scenarios;
    }

    public Scenario getScenarioById(int scenarioId) {
        Scenario scenario = null;
        String query = "SELECT * FROM Scenarios WHERE scenario_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, scenarioId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                scenario = new Scenario();
                scenario.setScenarioId(resultSet.getInt("scenario_id"));
                scenario.setTitle(resultSet.getString("title"));
                scenario.setDescription(resultSet.getString("description"));
                scenario.setKeywords(resultSet.getString("keywords"));
                scenario.setObjectives(resultSet.getString("objectives"));
                scenario.setCompetenciesAssessed(resultSet.getString("competencies_assessed"));
                scenario.setCreatedBy(resultSet.getInt("created_by"));
                scenario.setUpdatedBy(resultSet.getInt("updated_by"));
                scenario.setCreatedAt(resultSet.getTimestamp("created_at"));
                scenario.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                scenario.setVersion(resultSet.getInt("version"));
                scenario.setScenarioLevel(resultSet.getString("scenario_level"));
                scenario.setDifficultyLevel(resultSet.getString("difficulty_level"));
                scenario.setSemesterLevel(resultSet.getString("semester_level"));
                scenario.setPatientType(resultSet.getString("patient_type"));
                scenario.setBodySystemTopic(resultSet.getString("body_system_topic"));
                scenario.setMciSelection(resultSet.getString("mci_selection"));
                scenario.setFidelityLevel(resultSet.getString("fidelity_level"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scenario;
    }

    // Method to retrieve a scenario ID by title
    public int getScenarioIdByTitle(String title) {
        int scenarioId = -1;
        String query = "SELECT scenario_id FROM Scenarios WHERE title = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, title);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    scenarioId = resultSet.getInt("scenario_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scenarioId;
    }

    // Method to retrieve a scenario by title
    public Scenario getScenarioByTitle(String title) {
        Scenario scenario = null;
        String query = "SELECT * FROM Scenarios WHERE title = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, title);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    scenario = new Scenario();
                    scenario.setScenarioId(resultSet.getInt("scenario_id"));
                    scenario.setTitle(resultSet.getString("title"));
                    scenario.setDescription(resultSet.getString("description"));
                    scenario.setKeywords(resultSet.getString("keywords"));
                    scenario.setObjectives(resultSet.getString("objectives"));
                    scenario.setCompetenciesAssessed(resultSet.getString("competencies_assessed"));
                    scenario.setCreatedBy(resultSet.getInt("created_by"));
                    scenario.setCreatedAt(resultSet.getTimestamp("created_at"));
                    scenario.setUpdatedBy(resultSet.getInt("updated_by"));
                    scenario.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                    scenario.setVersion(resultSet.getInt("version"));
                    scenario.setScenarioLevel(resultSet.getString("scenario_level"));
                    scenario.setDifficultyLevel(resultSet.getString("difficulty_level"));
                    scenario.setSemesterLevel(resultSet.getString("semester_level"));
                    scenario.setPatientType(resultSet.getString("patient_type"));
                    scenario.setBodySystemTopic(resultSet.getString("body_system_topic"));
                    scenario.setMciSelection(resultSet.getString("mci_selection"));
                    scenario.setFidelityLevel(resultSet.getString("fidelity_level"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scenario;
    }

    // Method to get scenarios by user ID (creator)
    public List<Scenario> getScenariosByUserId(int userId) {
        List<Scenario> scenarios = new ArrayList<>();
        String query = "SELECT * FROM Scenarios WHERE created_by = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Scenario scenario = new Scenario();
                    scenario.setScenarioId(resultSet.getInt("scenario_id"));
                    scenario.setTitle(resultSet.getString("title"));
                    scenario.setDescription(resultSet.getString("description"));
                    scenario.setKeywords(resultSet.getString("keywords"));
                    scenario.setObjectives(resultSet.getString("objectives"));
                    scenario.setCompetenciesAssessed(resultSet.getString("competencies_assessed"));
                    scenario.setCreatedBy(resultSet.getInt("created_by"));
                    scenario.setCreatedAt(resultSet.getTimestamp("created_at"));
                    scenario.setUpdatedBy(resultSet.getInt("updated_by"));
                    scenario.setUpdatedAt(resultSet.getTimestamp("updated_at"));
                    scenario.setVersion(resultSet.getInt("version"));
                    scenario.setScenarioLevel(resultSet.getString("scenario_level"));
                    scenario.setDifficultyLevel(resultSet.getString("difficulty_level"));
                    scenario.setSemesterLevel(resultSet.getString("semester_level"));
                    scenario.setPatientType(resultSet.getString("patient_type"));
                    scenario.setBodySystemTopic(resultSet.getString("body_system_topic"));
                    scenario.setMciSelection(resultSet.getString("mci_selection"));
                    scenario.setFidelityLevel(resultSet.getString("fidelity_level"));
                    scenarios.add(scenario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scenarios;
    }

    public void updateScenario(Scenario scenario) {
        String query = "UPDATE Scenarios SET title = ?, description = ?, keywords = ?, objectives = ?, competencies_assessed = ?, created_by = ?, updated_by = ?, version = ?, scenario_level = ?, difficulty_level = ?, semester_level = ?, patient_type = ?, body_system_topic = ?, mci_selection = ?, fidelity_level = ? WHERE scenario_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, scenario.getTitle());
            preparedStatement.setString(2, scenario.getDescription());
            preparedStatement.setString(3, scenario.getKeywords());
            preparedStatement.setString(4, scenario.getObjectives());
            preparedStatement.setString(5, scenario.getCompetenciesAssessed());
            preparedStatement.setInt(6, scenario.getCreatedBy());
            preparedStatement.setInt(7, scenario.getUpdatedBy());
            preparedStatement.setInt(8, scenario.getVersion());
            preparedStatement.setString(9, scenario.getScenarioLevel());
            preparedStatement.setString(10, scenario.getDifficultyLevel());
            preparedStatement.setString(11, scenario.getSemesterLevel());
            preparedStatement.setString(12, scenario.getPatientType());
            preparedStatement.setString(13, scenario.getBodySystemTopic());
            preparedStatement.setString(14, scenario.getMciSelection());
            preparedStatement.setString(15, scenario.getFidelityLevel());
            preparedStatement.setInt(16, scenario.getScenarioId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a scenario
    public void deleteScenario(int scenarioId) {
        String query = "DELETE FROM Scenarios WHERE scenario_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, scenarioId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
