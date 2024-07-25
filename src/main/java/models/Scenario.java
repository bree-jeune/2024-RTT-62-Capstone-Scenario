package models;
import java.sql.Timestamp;

public class Scenario {
    private int scenarioId;
    private String title;
    private String description;
    private String keywords;
    private String objectives;
    private String competenciesAssessed;
    private int createdBy;
    private int updatedBy;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int version;
    private String scenarioLevel;
    private String difficultyLevel;
    private String semesterLevel;
    private String patientType;
    private String bodySystemTopic;
    private String mciSelection;
    private String fidelityLevel;

    // Getters and setters
    public int getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(int scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getCompetenciesAssessed() {
        return competenciesAssessed;
    }

    public void setCompetenciesAssessed(String competenciesAssessed) {
        this.competenciesAssessed = competenciesAssessed;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getScenarioLevel() {
        return scenarioLevel;
    }

    public void setScenarioLevel(String scenarioLevel) {
        this.scenarioLevel = scenarioLevel;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getSemesterLevel() {
        return semesterLevel;
    }

    public void setSemesterLevel(String semesterLevel) {
        this.semesterLevel = semesterLevel;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getBodySystemTopic() {
        return bodySystemTopic;
    }

    public void setBodySystemTopic(String bodySystemTopic) {
        this.bodySystemTopic = bodySystemTopic;
    }

    public String getMciSelection() {
        return mciSelection;
    }

    public void setMciSelection(String mciSelection) {
        this.mciSelection = mciSelection;
    }

    public String getFidelityLevel() {
        return fidelityLevel;
    }

    public void setFidelityLevel(String fidelityLevel) {
        this.fidelityLevel = fidelityLevel;
    }
}
