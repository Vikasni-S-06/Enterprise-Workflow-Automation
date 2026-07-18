package com.praveen.backend.test;

import com.praveen.backend.dao.UserDAO;
import com.praveen.backend.model.User;

public class TestUpdateUser {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        User user = dao.getUserByEmail("john.doe@workflow.com");

        if (user != null) {

            user.setPhone("9999999999");

            boolean updated = dao.updateUser(user);

            System.out.println(updated);

        }

    }

}