package com.praveen.backend.test;

import com.praveen.backend.dao.RoleDAO;
import com.praveen.backend.model.Role;

import java.util.List;

public class TestRoleDAO {

    public static void main(String[] args) {

        RoleDAO roleDAO = new RoleDAO();

        List<Role> roles = roleDAO.getAllRoles();

        for (Role role : roles) {
            System.out.println(role);
        }
    }
}