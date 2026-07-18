package com.praveen.backend.test;

import com.praveen.backend.dao.UserDAO;
import com.praveen.backend.model.Department;
import com.praveen.backend.model.Role;
import com.praveen.backend.model.User;
import com.praveen.backend.util.PasswordUtil;

import java.sql.Date;

public class TestSaveUser {

    public static void main(String[] args) {

        Role role = new Role();
        role.setRoleId(1); // EMPLOYEE

        Department department = new Department();
        department.setDepartmentId(1);

        User user = new User();

        user.setEmployeeCode("EMP100");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@workflow.com");
        user.setPasswordHash(PasswordUtil.hashPassword("john123"));
        user.setPhone("9876543299");
        user.setRole(role);
        user.setDepartment(department);
        user.setStatus("ACTIVE");
        user.setJoiningDate(Date.valueOf("2026-07-18"));

        UserDAO dao = new UserDAO();

        boolean saved = dao.saveUser(user);

        if (saved) {

            System.out.println("USER SAVED SUCCESSFULLY");

        } else {

            System.out.println("SAVE FAILED");

        }

    }

}