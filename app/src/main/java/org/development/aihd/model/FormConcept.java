package org.development.aihd.model;

import com.orm.SugarRecord;

public class FormConcept extends SugarRecord {

    private String conceptId;
    private String groupId;
    private String type;
    private String conceptAnswer;
    private String dateTime;
    private String comment;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConceptAnswer() {
        return conceptAnswer;
    }

    public void setConceptAnswer(String conceptAnswer) {
        this.conceptAnswer = conceptAnswer;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public FormConcept() {
    }

    // constructor
    public FormConcept(String conceptId, String groupId, String type, String conceptAnswer, String dateTime, String comment) {
        this.conceptId = conceptId;
        this.groupId = groupId;
        this.type = type;
        this.conceptAnswer = conceptAnswer;
        this.dateTime = dateTime;
        this.comment = comment;
    }

    public String getConceptId() {
        return conceptId;
    }

    public void setConceptId(String conceptId) {
        this.conceptId = conceptId;
    }
}
