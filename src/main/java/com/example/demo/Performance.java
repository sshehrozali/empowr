package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Optional;

@Entity
public class Performance {

    @Id
    private Integer Key;         // Primary Key
    private String Performance; // Access By Admin Only
    private String Feedback;  // Access By Employee Only

    // Empty Constructor
    public Performance() {
    }

    // Parameters Constructor
    public Performance(Integer key, String performance, String feedback) {
        Key = key;
        Performance = performance;
        Feedback = feedback;
    }

    // Getters & Setters
    public Integer getKey() {
        return Key;
    }

    public void setKey(Integer key) {
        Key = key;
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

    public Optional<com.example.demo.Performance> setFeedback(String feedback) {
        Feedback = feedback;
        return null;
    }
}
