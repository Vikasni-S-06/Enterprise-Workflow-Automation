package com.praveen.backend.test;

import com.praveen.backend.dao.UserDAO;
import com.praveen.backend.model.User;

import java.util.List;

public class TestGetAllUsers {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        List<User> users = dao.getAllUsers();

        System.out.println("========================");
        System.out.println("TOTAL USERS : " + users.size());
        System.out.println("========================");

        for (User user : users) {

            System.out.println(user);

        }

    }

}