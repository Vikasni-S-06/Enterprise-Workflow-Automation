package com.praveen.backend.test;

import com.praveen.backend.dao.UserDAO;

public class TestDeleteUser {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        boolean deleted = dao.deleteUser(5);

        System.out.println(deleted);

    }

}