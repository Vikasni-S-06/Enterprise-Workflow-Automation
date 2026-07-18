package com.praveen.backend.service;

import com.praveen.backend.dao.UserDAO;
import com.praveen.backend.model.User;
import com.praveen.backend.util.PasswordUtil;
import com.praveen.backend.util.ValidationUtil;

public class LoginServiceImpl implements LoginService {

    private final UserDAO userDAO = new UserDAO();

    @Override
    public User login(String email, String password) {

        // Validate Email
        if (!ValidationUtil.isValidEmail(email)) {

            System.out.println("Invalid Email");

            return null;

        }

        // Validate Password
        if (!ValidationUtil.isValidPassword(password)) {

            System.out.println("Invalid Password");

            return null;

        }

        // Fetch User
        User user = userDAO.getUserByEmail(email);

        if (user == null) {

            System.out.println("User Not Found");

            return null;

        }

        // Verify Password
        if (!PasswordUtil.verifyPassword(password, user.getPasswordHash())) {

            System.out.println("Incorrect Password");

            return null;

        }

        // Update Last Login Time
        userDAO.updateLastLogin(user.getUserId());

        return user;

    }

}