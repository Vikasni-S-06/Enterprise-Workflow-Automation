package com.praveen.backend.test;

import com.praveen.backend.dao.UserDAO;
import com.praveen.backend.model.User;

public class TestGetUserById {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        User user = dao.getUserById(4);

        if (user != null) {

            System.out.println("================================");
            System.out.println("USER FOUND");
            System.out.println("================================");
            System.out.println(user);

        } else {

            System.out.println("User Not Found");

        }

    }

}