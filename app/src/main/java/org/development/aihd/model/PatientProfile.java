package org.development.aihd.model;

import com.orm.SugarRecord;

public class PatientProfile extends SugarRecord {

    private String patientID;
    private String medicationFile;

    public PatientProfile() {
    }

    public PatientProfile(String patientID, String medicationFile) {
        this.patientID = patientID;
        this.medicationFile = medicationFile;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getMedicationFile() {
        return medicationFile;
    }

    public void setMedicationFile(String medicationFile) {
        this.medicationFile = medicationFile;
    }

}
