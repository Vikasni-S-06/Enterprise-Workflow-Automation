package com.praveen.backend.service;

import com.praveen.backend.dao.UserDAO;
import com.praveen.backend.model.User;
import com.praveen.backend.util.PasswordUtil;
import com.praveen.backend.util.ValidationUtil;

public class LoginServiceImpl implements LoginService {

    private final UserDAO userDAO = new UserDAO();

    @Override
    public User login(String email, String password) {

        // Validate email
        if (!ValidationUtil.isValidEmail(email)) {
            return null;
        }

        // Validate password
        if (!ValidationUtil.isValidPassword(password)) {
            return null;
        }

        // Fetch user
        User user = userDAO.getUserByEmail(email);

        if (user == null) {
            return null;
        }

        // Verify password
        if (!PasswordUtil.verifyPassword(password, user.getPasswordHash())) {
            return null;
        }

        // Update last login (we'll implement this method next)
        // userDAO.updateLastLogin(user.getUserId());

        return user;
    }
}