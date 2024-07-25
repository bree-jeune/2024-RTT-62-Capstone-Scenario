package org.example;

import dao.*;
import models.*;

import java.sql.Timestamp;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize DAOs
        UserDAO userDAO = new UserDAO();
        InstructorDAO instructorDAO = new InstructorDAO();
        StudentDAO studentDAO = new StudentDAO();
        ScenarioDAO scenarioDAO = new ScenarioDAO();
        ScenarioDetailDAO scenarioDetailDAO = new ScenarioDetailDAO();
        UserScenarioDAO userScenarioDAO = new UserScenarioDAO();
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        PerformanceReportDAO performanceReportDAO = new PerformanceReportDAO();
        ForumDAO forumDAO = new ForumDAO();
        ForumPostDAO forumPostDAO = new ForumPostDAO();

        // Example: Adding a new user if not already exists
        String username = "john_doe";
        User user = userDAO.getUserByUsername(username);
        if (user == null) {
            user = new User();
            user.setUsername(username);
            user.setPasswordHash("hashed_password");
            user.setEmail("john_doe@example.com");
            user.setRole("student");
            userDAO.addUser(user);
            user.setUserId(userDAO.getUserIdByUsername(username));
        }

        int userId = user.getUserId();

        // Example: Adding a new instructor if not already exists
        Instructor instructor = instructorDAO.getInstructorById(userId);
        if (instructor == null) {
            instructor = new Instructor();
            instructor.setInstructorId(userId);
            instructor.setFirstName("John");
            instructor.setLastName("Doe");
            instructor.setCertifications("Paramedic");
            instructorDAO.addInstructor(instructor);
        }

        // Example: Adding a new student if not already exists
        Student student = studentDAO.getStudentById(userId);
        if (student == null) {
            student = new Student();
            student.setStudentId(userId);
            student.setFirstName("Jane");
            student.setLastName("Smith");
            student.setEnrollmentDate(new java.sql.Date(System.currentTimeMillis()));
            student.setProgram("Paramedicine");
            student.setCompetencyLevel("Intermediate");
            student.setNumberOfTeamLeads(3);
            studentDAO.addStudent(student);
        }

        // Example: Adding a new scenario if not already exists
        String scenarioTitle = "Cardiac Arrest";
        Scenario scenario = scenarioDAO.getScenarioByTitle(scenarioTitle);
        if (scenario == null) {
            scenario = new Scenario();
            scenario.setTitle(scenarioTitle);
            scenario.setDescription("A 55-year-old male found unresponsive.");
            scenario.setKeywords("Cardiac, Emergency");
            scenario.setObjectives("Assess and manage a cardiac arrest patient.");
            scenario.setCompetenciesAssessed("CPR, AED use");
            scenario.setCreatedBy(userId);
            scenario.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            scenario.setUpdatedBy(userId);
            scenario.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            scenario.setVersion(1);
            scenario.setScenarioLevel("ALS");
            scenario.setDifficultyLevel("Advanced");
            scenario.setSemesterLevel("V");
            scenario.setPatientType("Adult");
            scenario.setBodySystemTopic("Cardiology");
            scenario.setMciSelection("No");
            scenario.setFidelityLevel("High");
            scenarioDAO.addScenario(scenario);
            scenario.setScenarioId(scenarioDAO.getScenarioIdByTitle(scenarioTitle));
        }

        int scenarioId = scenario.getScenarioId();

        // Example: Adding scenario details if not already exists
        ScenarioDetails scenarioDetail = scenarioDetailDAO.getScenarioDetailByScenarioId(scenarioId);
        if (scenarioDetail == null) {
            scenarioDetail = new ScenarioDetails();
            scenarioDetail.setScenarioId(scenarioId);
            scenarioDetail.setPatientHistory("Patient has a history of hypertension.");
            scenarioDetail.setSymptoms("Unresponsive, no pulse.");
            scenarioDetail.setVitalSigns("N/A");
            scenarioDetail.setMediaUrl("http://example.com/media");
            scenarioDetail.setSpecialEquipment("AED, CPR board");
            scenarioDetail.setRequiredMedications("Epinephrine");
            scenarioDetail.setTriageNotes("N/A");
            scenarioDetail.setSceneDescription("Patient found in a park.");
            scenarioDetail.setPatientReaction("No response to initial CPR.");
            scenarioDetail.setPatientName("John Doe");
            scenarioDetail.setPatientAge(55);
            scenarioDetail.setPatientWeight(85.0);
            scenarioDetail.setProgressiveVitals("N/A");
            scenarioDetail.setDecompensationVitals("N/A");
            scenarioDetail.setFirstIntervention(new Timestamp(System.currentTimeMillis()));
            scenarioDetailDAO.addScenarioDetail(scenarioDetail);
        }

        // Example: Retrieving and displaying all users
        List<User> users = userDAO.getAllUsers();
        for (User u : users) {
            System.out.println("User ID: " + u.getUserId());
            System.out.println("Username: " + u.getUsername());
            System.out.println("Email: " + u.getEmail());
            System.out.println("Role: " + u.getRole());
        }

        // Example: Retrieving and displaying all scenarios
        List<Scenario> scenarios = scenarioDAO.getAllScenarios();
        for (Scenario s : scenarios) {
            System.out.println("Scenario ID: " + s.getScenarioId());
            System.out.println("Title: " + s.getTitle());
            System.out.println("Description: " + s.getDescription());
            // Print other details as needed
        }

        // Example: Updating a user
        user.setEmail("john_updated@example.com");
        userDAO.updateUser(user);

        // Example: Deleting a user
        userId = 1; // Replace with the actual user ID

        // Delete related scenarios and scenario details
        List<Scenario> userScenarios = scenarioDAO.getScenariosByUserId(userId);
        for (Scenario s : userScenarios) {
            scenarioDetailDAO.deleteScenarioDetailsByScenarioId(s.getScenarioId());
            scenarioDAO.deleteScenario(s.getScenarioId());
        }

        // Delete related instructor record
        instructorDAO.deleteInstructorByUserId(userId);

        // Delete related student record (if applicable)
        studentDAO.deleteStudentByUserId(userId);

        // Delete the user
        userDAO.deleteUser(userId);
    }
}
