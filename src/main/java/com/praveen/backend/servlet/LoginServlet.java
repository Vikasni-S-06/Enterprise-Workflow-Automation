package com.praveen.backend.servlet;

import com.praveen.backend.model.User;
import com.praveen.backend.service.LoginService;
import com.praveen.backend.service.LoginServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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

        if (user != null) {

            HttpSession session = request.getSession();

            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userName",
                    user.getFirstName() + " " + user.getLastName());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("role", user.getRole().getRoleName());

            String role = user.getRole().getRoleName();

            switch (role) {

                case "ADMIN":
                    response.sendRedirect("admin/dashboard.jsp");
                    break;

                case "HR":
                    response.sendRedirect("hr/dashboard.jsp");
                    break;

                case "MANAGER":
                    response.sendRedirect("manager/dashboard.jsp");
                    break;

                case "EMPLOYEE":
                    response.sendRedirect("employee/dashboard.jsp");
                    break;

                default:
                    response.sendRedirect("login.jsp?error=role");
                    break;
            }

        } else {

            response.sendRedirect("login.jsp?error=invalid");

        }
    }
}