package com.praveen.backend.test;

import com.praveen.backend.dao.UserDAO;
import com.praveen.backend.model.User;

public class TestUserDAO {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();

        User user = userDAO.getUserByEmail("admin@workflow.com");

        if (user != null) {

            System.out.println("================================");
            System.out.println("User Found");
            System.out.println("================================");

            System.out.println(user);

        } else {

            System.out.println("User Not Found");

        }

    }

}