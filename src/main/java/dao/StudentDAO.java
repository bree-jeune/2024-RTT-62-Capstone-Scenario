package dao;
import org.example.DatabaseConnection;
import models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Method to add a student
    public void addStudent(Student student) {
        String query = "INSERT INTO Students (student_id, first_name, last_name, enrollment_date, program, competency_level, number_of_team_leads) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setDate(4, student.getEnrollmentDate());
            preparedStatement.setString(5, student.getProgram());
            preparedStatement.setString(6, student.getCompetencyLevel());
            preparedStatement.setInt(7, student.getNumberOfTeamLeads());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM Students";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setEnrollmentDate(resultSet.getDate("enrollment_date"));
                student.setProgram(resultSet.getString("program"));
                student.setCompetencyLevel(resultSet.getString("competency_level"));
                student.setNumberOfTeamLeads(resultSet.getInt("number_of_team_leads"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Method to retrieve a student by ID
    public Student getStudentById(int studentId) {
        Student student = null;
        String query = "SELECT * FROM Students WHERE student_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, studentId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    student = new Student();
                    student.setStudentId(resultSet.getInt("student_id"));
                    student.setFirstName(resultSet.getString("first_name"));
                    student.setLastName(resultSet.getString("last_name"));
                    student.setEnrollmentDate(resultSet.getDate("enrollment_date"));
                    student.setProgram(resultSet.getString("program"));
                    student.setCompetencyLevel(resultSet.getString("competency_level"));
                    student.setNumberOfTeamLeads(resultSet.getInt("number_of_team_leads"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    // Method to update a student
    public void updateStudent(Student student) {
        String query = "UPDATE Students SET first_name = ?, last_name = ?, enrollment_date = ?, program = ?, competency_level = ?, number_of_team_leads = ? WHERE student_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setDate(3, student.getEnrollmentDate());
            preparedStatement.setString(4, student.getProgram());
            preparedStatement.setString(5, student.getCompetencyLevel());
            preparedStatement.setInt(6, student.getNumberOfTeamLeads());
            preparedStatement.setInt(7, student.getStudentId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a student
    public void deleteStudent(int studentId) {
        String query = "DELETE FROM Students WHERE student_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudentByUserId(int userId) {
        String query = "DELETE FROM Students WHERE student_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
