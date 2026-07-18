package com.praveen.backend.servlet;

import com.praveen.backend.model.User;
import com.praveen.backend.service.LoginService;
import com.praveen.backend.service.LoginServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = loginService.login(email, password);

        response.setContentType("text/plain");

        if (user != null) {

            HttpSession session = request.getSession(true);

            session.setAttribute("loggedInUser", user);

            session.setAttribute("role",
                    user.getRole().getRoleName());

            response.getWriter().println("LOGIN SUCCESS");

        } else {

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            response.getWriter().println("LOGIN FAILED");

        }
    }
}