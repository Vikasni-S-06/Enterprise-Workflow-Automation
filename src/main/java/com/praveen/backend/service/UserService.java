package com.praveen.backend.service;

import com.praveen.backend.model.User;

import java.util.List;

public interface UserService {

    // ==========================================
    // LOGIN
    // ==========================================

    User login(String email, String password);

    // ==========================================
    // CRUD
    // ==========================================

    boolean saveUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int userId);

    User getUserById(int userId);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    // ==========================================
    // VALIDATION
    // ==========================================

    boolean emailExists(String email);

    boolean employeeCodeExists(String employeeCode);

    boolean emailExistsForAnotherUser(String email,
                                      int userId);

    // ==========================================
    // SEARCH
    // ==========================================

    List<User> searchUsers(String keyword);

    // ==========================================
    // PAGINATION
    // ==========================================

    List<User> getUsersByPage(int offset,
                              int pageSize);

    int getUserCount();

    // ==========================================
    // LOGIN HISTORY
    // ==========================================

    boolean updateLastLogin(int userId);

}