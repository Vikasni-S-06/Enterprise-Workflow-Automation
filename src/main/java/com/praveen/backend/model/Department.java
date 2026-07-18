package com.praveen.backend.model;

import java.io.Serializable;

/**
 * Represents a department in the Enterprise Workflow Automation System.
 *
 * Examples:
 * Engineering
 * Human Resources
 * Finance
 * Operations
 */
public class Department implements Serializable {

    private int departmentId;
    private String departmentName;

    // Default Constructor
    public Department() {
    }

    // Parameterized Constructor
    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    // Getter
    public int getDepartmentId() {
        return departmentId;
    }

    // Setter
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    // Getter
    public String getDepartmentName() {
        return departmentName;
    }

    // Setter
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}