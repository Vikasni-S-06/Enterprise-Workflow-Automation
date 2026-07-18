package com.praveen.backend.test;

import com.praveen.backend.dao.UserDAO;
import com.praveen.backend.model.User;

public class TestUserById {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        User user = dao.getUserById(4);

        System.out.println(user);

    }

}