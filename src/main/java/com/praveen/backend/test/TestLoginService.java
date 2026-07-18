package com.praveen.backend.test;

import com.praveen.backend.model.User;
import com.praveen.backend.service.LoginService;
import com.praveen.backend.service.LoginServiceImpl;

public class TestLoginService {

    public static void main(String[] args) {

        LoginService loginService = new LoginServiceImpl();

        User user = loginService.login(
                "admin@workflow.com",
                "admin123"
        );

        if (user != null) {

            System.out.println("================================");
            System.out.println("LOGIN SUCCESS");
            System.out.println("================================");

            System.out.println(user);

        } else {

            System.out.println("LOGIN FAILED");

        }

    }

}