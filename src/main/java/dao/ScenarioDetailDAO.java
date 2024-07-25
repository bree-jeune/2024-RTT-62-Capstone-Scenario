package dao;
import org.example.DatabaseConnection;
import models.ScenarioDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScenarioDetailDAO {

    // Method to add a scenario detail
    public void addScenarioDetail(ScenarioDetails scenarioDetail) {
        String query = "INSERT INTO ScenarioDetails (scenario_id, patient_history, symptoms, vital_signs, media_url, special_equipment, required_medications, triage_notes, scene_description, patient_reaction, patient_name, patient_age, patient_weight, progressive_vitals, decompensation_vitals, first_intervention) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, scenarioDetail.getScenarioId());
            preparedStatement.setString(2, scenarioDetail.getPatientHistory());
            preparedStatement.setString(3, scenarioDetail.getSymptoms());
            preparedStatement.setString(4, scenarioDetail.getVitalSigns());
            preparedStatement.setString(5, scenarioDetail.getMediaUrl());
            preparedStatement.setString(6, scenarioDetail.getSpecialEquipment());
            preparedStatement.setString(7, scenarioDetail.getRequiredMedications());
            preparedStatement.setString(8, scenarioDetail.getTriageNotes());
            preparedStatement.setString(9, scenarioDetail.getSceneDescription());
            preparedStatement.setString(10, scenarioDetail.getPatientReaction());
            preparedStatement.setString(11, scenarioDetail.getPatientName());
            preparedStatement.setInt(12, scenarioDetail.getPatientAge());
            preparedStatement.setDouble(13, scenarioDetail.getPatientWeight());
            preparedStatement.setString(14, scenarioDetail.getProgressiveVitals());
            preparedStatement.setString(15, scenarioDetail.getDecompensationVitals());
            preparedStatement.setTimestamp(16, scenarioDetail.getFirstIntervention());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all scenario details
    public List<ScenarioDetails> getAllScenarioDetails() {
        List<ScenarioDetails> scenarioDetails = new ArrayList<>();
        String query = "SELECT * FROM ScenarioDetails";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ScenarioDetails scenarioDetail = new ScenarioDetails();
                scenarioDetail.setScenarioDetailId(resultSet.getInt("scenario_detail_id"));
                scenarioDetail.setScenarioId(resultSet.getInt("scenario_id"));
                scenarioDetail.setPatientHistory(resultSet.getString("patient_history"));
                scenarioDetail.setSymptoms(resultSet.getString("symptoms"));
                scenarioDetail.setVitalSigns(resultSet.getString("vital_signs"));
                scenarioDetail.setMediaUrl(resultSet.getString("media_url"));
                scenarioDetail.setSpecialEquipment(resultSet.getString("special_equipment"));
                scenarioDetail.setRequiredMedications(resultSet.getString("required_medications"));
                scenarioDetail.setTriageNotes(resultSet.getString("triage_notes"));
                scenarioDetail.setSceneDescription(resultSet.getString("scene_description"));
                scenarioDetail.setPatientReaction(resultSet.getString("patient_reaction"));
                scenarioDetail.setPatientName(resultSet.getString("patient_name"));
                scenarioDetail.setPatientAge(resultSet.getInt("patient_age"));
                scenarioDetail.setPatientWeight(resultSet.getDouble("patient_weight"));
                scenarioDetail.setProgressiveVitals(resultSet.getString("progressive_vitals"));
                scenarioDetail.setDecompensationVitals(resultSet.getString("decompensation_vitals"));
                scenarioDetail.setFirstIntervention(resultSet.getTimestamp("first_intervention"));
                scenarioDetails.add(scenarioDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scenarioDetails;
    }

    // Method to retrieve a scenario detail by scenario ID
    public ScenarioDetails getScenarioDetailByScenarioId(int scenarioId) {
        ScenarioDetails scenarioDetail = null;
        String query = "SELECT * FROM ScenarioDetails WHERE scenario_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, scenarioId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    scenarioDetail = new ScenarioDetails();
                    scenarioDetail.setScenarioDetailId(resultSet.getInt("scenario_detail_id"));
                    scenarioDetail.setScenarioId(resultSet.getInt("scenario_id"));
                    scenarioDetail.setPatientHistory(resultSet.getString("patient_history"));
                    scenarioDetail.setSymptoms(resultSet.getString("symptoms"));
                    scenarioDetail.setVitalSigns(resultSet.getString("vital_signs"));
                    scenarioDetail.setMediaUrl(resultSet.getString("media_url"));
                    scenarioDetail.setSpecialEquipment(resultSet.getString("special_equipment"));
                    scenarioDetail.setRequiredMedications(resultSet.getString("required_medications"));
                    scenarioDetail.setTriageNotes(resultSet.getString("triage_notes"));
                    scenarioDetail.setSceneDescription(resultSet.getString("scene_description"));
                    scenarioDetail.setPatientReaction(resultSet.getString("patient_reaction"));
                    scenarioDetail.setPatientName(resultSet.getString("patient_name"));
                    scenarioDetail.setPatientAge(resultSet.getInt("patient_age"));
                    scenarioDetail.setPatientWeight(resultSet.getDouble("patient_weight"));
                    scenarioDetail.setProgressiveVitals(resultSet.getString("progressive_vitals"));
                    scenarioDetail.setDecompensationVitals(resultSet.getString("decompensation_vitals"));
                    scenarioDetail.setFirstIntervention(resultSet.getTimestamp("first_intervention"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scenarioDetail;
    }

    // Method to update a scenario detail
    public void updateScenarioDetail(ScenarioDetails scenarioDetail) {
        String query = "UPDATE ScenarioDetails SET scenario_id = ?, patient_history = ?, symptoms = ?, vital_signs = ?, media_url = ?, special_equipment = ?, required_medications = ?, triage_notes = ?, scene_description = ?, patient_reaction = ?, patient_name = ?, patient_age = ?, patient_weight = ?, progressive_vitals = ?, decompensation_vitals = ?, first_intervention = ? WHERE scenario_detail_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, scenarioDetail.getScenarioId());
            preparedStatement.setString(2, scenarioDetail.getPatientHistory());
            preparedStatement.setString(3, scenarioDetail.getSymptoms());
            preparedStatement.setString(4, scenarioDetail.getVitalSigns());
            preparedStatement.setString(5, scenarioDetail.getMediaUrl());
            preparedStatement.setString(6, scenarioDetail.getSpecialEquipment());
            preparedStatement.setString(7, scenarioDetail.getRequiredMedications());
            preparedStatement.setString(8, scenarioDetail.getTriageNotes());
            preparedStatement.setString(9, scenarioDetail.getSceneDescription());
            preparedStatement.setString(10, scenarioDetail.getPatientReaction());
            preparedStatement.setString(11, scenarioDetail.getPatientName());
            preparedStatement.setInt(12, scenarioDetail.getPatientAge());
            preparedStatement.setDouble(13, scenarioDetail.getPatientWeight());
            preparedStatement.setString(14, scenarioDetail.getProgressiveVitals());
            preparedStatement.setString(15, scenarioDetail.getDecompensationVitals());
            preparedStatement.setTimestamp(16, scenarioDetail.getFirstIntervention());
            preparedStatement.setInt(17, scenarioDetail.getScenarioDetailId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete scenario details by scenario ID
    public void deleteScenarioDetailsByScenarioId(int scenarioId) {
        String query = "DELETE FROM ScenarioDetails WHERE scenario_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, scenarioId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a scenario detail
    public void deleteScenarioDetail(int scenarioDetailId) {
        String query = "DELETE FROM ScenarioDetails WHERE scenario_detail_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, scenarioDetailId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
