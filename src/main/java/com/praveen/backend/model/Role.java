package com.praveen.backend.model;

import java.io.Serializable;

/**
 * Represents a user role in the Enterprise Workflow Automation System.
 *
 * Examples:
 * ADMIN
 * HR
 * MANAGER
 * EMPLOYEE
 */
public class Role implements Serializable {

    private int roleId;
    private String roleName;

    // Default Constructor
    public Role() {
    }

    // Parameterized Constructor
    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    // Getter
    public int getRoleId() {
        return roleId;
    }

    // Setter
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    // Getter
    public String getRoleName() {
        return roleName;
    }

    // Setter
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}

