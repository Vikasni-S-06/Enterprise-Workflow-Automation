package com.praveen.backend.service;

import com.praveen.backend.model.User;

public interface LoginService {

    User login(String email, String password);

}