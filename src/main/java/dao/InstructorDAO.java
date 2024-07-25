package dao;
import org.example.DatabaseConnection;
import models.Instructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorDAO {

    // Method to add an instructor
    public void addInstructor(Instructor instructor) {
        String query = "INSERT INTO Instructors (instructor_id, first_name, last_name, certifications) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, instructor.getInstructorId());
            preparedStatement.setString(2, instructor.getFirstName());
            preparedStatement.setString(3, instructor.getLastName());
            preparedStatement.setString(4, instructor.getCertifications());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all instructors
    public List<Instructor> getAllInstructors() {
        List<Instructor> instructors = new ArrayList<>();
        String query = "SELECT * FROM Instructors";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Instructor instructor = new Instructor();
                instructor.setInstructorId(resultSet.getInt("instructor_id"));
                instructor.setFirstName(resultSet.getString("first_name"));
                instructor.setLastName(resultSet.getString("last_name"));
                instructor.setCertifications(resultSet.getString("certifications"));
                instructors.add(instructor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instructors;
    }

    // Method to retrieve an instructor by ID
    public Instructor getInstructorById(int instructorId) {
        String query = "SELECT * FROM Instructors WHERE instructor_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, instructorId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Instructor instructor = new Instructor();
                    instructor.setInstructorId(resultSet.getInt("instructor_id"));
                    instructor.setFirstName(resultSet.getString("first_name"));
                    instructor.setLastName(resultSet.getString("last_name"));
                    instructor.setCertifications(resultSet.getString("certifications"));
                    return instructor;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to update an instructor
    public void updateInstructor(Instructor instructor) {
        String query = "UPDATE Instructors SET first_name = ?, last_name = ?, certifications = ? WHERE instructor_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, instructor.getFirstName());
            preparedStatement.setString(2, instructor.getLastName());
            preparedStatement.setString(3, instructor.getCertifications());
            preparedStatement.setInt(4, instructor.getInstructorId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete an instructor
    public void deleteInstructor(int instructorId) {
        String query = "DELETE FROM Instructors WHERE instructor_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, instructorId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteInstructorByUserId(int userId) {
        String query = "DELETE FROM Instructors WHERE instructor_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
