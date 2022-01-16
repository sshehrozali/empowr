package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Performance {

    @Id
    private Integer ID;         // Primary Key
    private String Performance; // Access By Admin Only
    private String Feedback;  // Access By Employee Only

    // Empty Constructor
    public Performance() {
    }

    // Parameters Constructor
    public Performance(Integer ID, String performance, String feedback) {
        this.ID = ID;
        Performance = performance;
        Feedback = feedback;
    }

    // Getters & Setters
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPerformance() {
        return Performance;
    }

    public void setPerformance(String performance) {
        Performance = performance;
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String feedback) {
        Feedback = feedback;
    }
}
