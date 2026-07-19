package com.praveen.backend.service;

import com.praveen.backend.dao.UserDAO;
import com.praveen.backend.model.User;
import com.praveen.backend.util.PasswordUtil;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO = new UserDAO();

    // ==========================================
    // LOGIN
    // ==========================================

    @Override
    public User login(String email, String password) {

        User user = userDAO.getUserByEmail(email);

        if (user != null &&
                PasswordUtil.checkPassword(
                        password,
                        user.getPasswordHash())) {

            userDAO.updateLastLogin(
                    user.getUserId());

            return user;
        }

        return null;
    }

    // ==========================================
    // CRUD
    // ==========================================

    @Override
    public boolean saveUser(User user) {
        return userDAO.saveUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public boolean deleteUser(int userId) {
        return userDAO.deleteUser(userId);
    }

    @Override
    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    // ==========================================
    // VALIDATION
    // ==========================================

    @Override
    public boolean emailExists(String email) {
        return userDAO.emailExists(email);
    }

    @Override
    public boolean employeeCodeExists(String employeeCode) {
        return userDAO.employeeCodeExists(employeeCode);
    }

    @Override
    public boolean emailExistsForAnotherUser(String email,
                                             int userId) {

        return userDAO.emailExistsForAnotherUser(
                email,
                userId);
    }

    // ==========================================
    // SEARCH
    // ==========================================

    @Override
    public List<User> searchUsers(String keyword) {
        return userDAO.searchUsers(keyword);
    }

    // ==========================================
    // PAGINATION
    // ==========================================

    @Override
    public List<User> getUsersByPage(int offset,
                                     int pageSize) {

        return userDAO.getUsersByPage(
                offset,
                pageSize);
    }

    @Override
    public int getUserCount() {
        return userDAO.getUserCount();
    }

    // ==========================================
    // LOGIN HISTORY
    // ==========================================

    @Override
    public boolean updateLastLogin(int userId) {
        return userDAO.updateLastLogin(userId);
    }

}