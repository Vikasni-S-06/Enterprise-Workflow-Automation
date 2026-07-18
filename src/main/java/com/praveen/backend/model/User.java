package com.praveen.backend.model;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {

    private int userId;
    private String employeeCode;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private String phone;

    private Role role;
    private Department department;

    private String status;

    private Date joiningDate;

    private java.sql.Timestamp lastLogin;

    private java.sql.Timestamp createdAt;

    private java.sql.Timestamp updatedAt;

    public User() {
    }

    public User(int userId,
                String employeeCode,
                String firstName,
                String lastName,
                String email,
                String passwordHash,
                String phone,
                Role role,
                Department department,
                String status,
                Date joiningDate,
                java.sql.Timestamp lastLogin,
                java.sql.Timestamp createdAt,
                java.sql.Timestamp updatedAt) {

        this.userId = userId;
        this.employeeCode = employeeCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.phone = phone;
        this.role = role;
        this.department = department;
        this.status = status;
        this.joiningDate = joiningDate;
        this.lastLogin = lastLogin;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public java.sql.Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(java.sql.Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public java.sql.Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(java.sql.Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", employeeCode='" + employeeCode + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + email + '\'' +
                ", role=" + (role != null ? role.getRoleName() : "") +
                ", department=" + (department != null ? department.getDepartmentName() : "") +
                ", status='" + status + '\'' +
                '}';
    }
}