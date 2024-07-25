package models;

import java.sql.Timestamp;

public class UserScenario {
    private int userScenarioId;
    private int userId;
    private int scenarioId;
    private boolean teamLead;
    private String status;
    private double score;
    private Timestamp attemptedAt;
    private Timestamp completedAt;

    // Getters and setters
    public int getUserScenarioId() {
        return userScenarioId;
    }

    public void setUserScenarioId(int userScenarioId) {
        this.userScenarioId = userScenarioId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(int scenarioId) {
        this.scenarioId = scenarioId;
    }

    public boolean isTeamLead() {
        return teamLead;
    }

    public void setTeamLead(boolean teamLead) {
        this.teamLead = teamLead;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Timestamp getAttemptedAt() {
        return attemptedAt;
    }

    public void setAttemptedAt(Timestamp attemptedAt) {
        this.attemptedAt = attemptedAt;
    }

    public Timestamp getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Timestamp completedAt) {
        this.completedAt = completedAt;
    }
}

