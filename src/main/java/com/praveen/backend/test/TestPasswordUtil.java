package com.praveen.backend.test;

import com.praveen.backend.util.PasswordUtil;

public class TestPasswordUtil {

    public static void main(String[] args) {

        String password = "admin123";

        String hashed = PasswordUtil.hashPassword(password);

        System.out.println("Original Password : " + password);

        System.out.println("Hashed Password   : " + hashed);

        boolean result =
                PasswordUtil.verifyPassword(password, hashed);

        System.out.println("Password Match : " + result);

    }

}