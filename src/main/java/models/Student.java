package models;

import java.sql.Date;

public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private Date enrollmentDate;
    private String program;
    private String competencyLevel;
    private int numberOfTeamLeads;

    // Getters and setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getCompetencyLevel() {
        return competencyLevel;
    }

    public void setCompetencyLevel(String competencyLevel) {
        this.competencyLevel = competencyLevel;
    }

    public int getNumberOfTeamLeads() {
        return numberOfTeamLeads;
    }

    public void setNumberOfTeamLeads(int numberOfTeamLeads) {
        this.numberOfTeamLeads = numberOfTeamLeads;
    }
}
