package models;

import java.sql.Timestamp;

public class ScenarioDetails {
    private int scenarioDetailId;
    private int scenarioId;
    private String patientHistory;
    private String symptoms;
    private String vitalSigns;
    private String mediaUrl;
    private String specialEquipment;
    private String requiredMedications;
    private String triageNotes;
    private String sceneDescription;
    private String patientReaction;
    private String patientName;
    private int patientAge;
    private double patientWeight;
    private String progressiveVitals;
    private String decompensationVitals;
    private Timestamp firstIntervention;

    // Getters and setters
    public int getScenarioDetailId() {
        return scenarioDetailId;
    }

    public void setScenarioDetailId(int scenarioDetailId) {
        this.scenarioDetailId = scenarioDetailId;
    }

    public int getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(int scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(String patientHistory) {
        this.patientHistory = patientHistory;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(String vitalSigns) {
        this.vitalSigns = vitalSigns;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getSpecialEquipment() {
        return specialEquipment;
    }

    public void setSpecialEquipment(String specialEquipment) {
        this.specialEquipment = specialEquipment;
    }

    public String getRequiredMedications() {
        return requiredMedications;
    }

    public void setRequiredMedications(String requiredMedications) {
        this.requiredMedications = requiredMedications;
    }

    public String getTriageNotes() {
        return triageNotes;
    }

    public void setTriageNotes(String triageNotes) {
        this.triageNotes = triageNotes;
    }

    public String getSceneDescription() {
        return sceneDescription;
    }

    public void setSceneDescription(String sceneDescription) {
        this.sceneDescription = sceneDescription;
    }

    public String getPatientReaction() {
        return patientReaction;
    }

    public void setPatientReaction(String patientReaction) {
        this.patientReaction = patientReaction;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public double getPatientWeight() {
        return patientWeight;
    }

    public void setPatientWeight(double patientWeight) {
        this.patientWeight = patientWeight;
    }

    public String getProgressiveVitals() {
        return progressiveVitals;
    }

    public void setProgressiveVitals(String progressiveVitals) {
        this.progressiveVitals = progressiveVitals;
    }

    public String getDecompensationVitals() {
        return decompensationVitals;
    }

    public void setDecompensationVitals(String decompensationVitals) {
        this.decompensationVitals = decompensationVitals;
    }

    public Timestamp getFirstIntervention() {
        return firstIntervention;
    }

    public void setFirstIntervention(Timestamp firstIntervention) {
        this.firstIntervention = firstIntervention;
    }
}
