package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feedback {

    @Id
    private Integer FeedbackEmployeeID;
    private String FeedbackTobeSubmitted;

    // Empty Constructor
    public Feedback() {
    }

    // Parameters Constructor
    public Feedback(Integer feedbackEmployeeID, String feedbackTobeSubmitted) {
        FeedbackEmployeeID = feedbackEmployeeID;
        FeedbackTobeSubmitted = feedbackTobeSubmitted;
    }

    // Getters & Setters
    public Integer getFeedbackEmployeeID() {
        return FeedbackEmployeeID;
    }

    public void setFeedbackEmployeeID(Integer feedbackEmployeeID) {
        FeedbackEmployeeID = feedbackEmployeeID;
    }

    public String getFeedbackTobeSubmitted() {
        return FeedbackTobeSubmitted;
    }

    public void setFeedbackTobeSubmitted(String feedbackTobeSubmitted) {
        FeedbackTobeSubmitted = feedbackTobeSubmitted;
    }
}
