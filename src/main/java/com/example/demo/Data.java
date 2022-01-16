package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Data {

    @Id
    private Integer EmployeeID; // Primary Key
    private String EmployeeName;    // Employee Name
    private boolean EmployeeParticipation;  // Access Given by Admin ONLY

    // Empty Constructor
    public Data() {
    }

    // Parameters Constructor
    public Data(Integer employeeID, String employeeName, boolean employeeParticipation) {
        EmployeeID = employeeID;
        EmployeeName = employeeName;
        EmployeeParticipation = employeeParticipation;
    }

    // Getters & Setters
    public Integer getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public boolean isEmployeeParticipation() {
        return EmployeeParticipation;
    }

    public void setEmployeeParticipation(boolean employeeParticipation) {
        EmployeeParticipation = employeeParticipation;
    }
}
