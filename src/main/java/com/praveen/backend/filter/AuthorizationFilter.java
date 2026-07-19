package com.praveen.backend.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {
        "/admin/*",
        "/employee/*",
        "/manager/*",
        "/hr/*"
})
public class AuthorizationFilter extends HttpFilter implements Filter {

    @Override
    protected void doFilter(HttpServletRequest request,
                            HttpServletResponse response,
                            FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = request.getSession(false);

        String role = (String) session.getAttribute("role");

        String uri = request.getRequestURI();

        if (uri.contains("/admin") && !"ADMIN".equals(role)) {
            response.sendRedirect(request.getContextPath() + "/access-denied.jsp");
            return;
        }

        if (uri.contains("/manager") && !"MANAGER".equals(role)) {
            response.sendRedirect(request.getContextPath() + "/access-denied.jsp");
            return;
        }

        if (uri.contains("/hr") && !"HR".equals(role)) {
            response.sendRedirect(request.getContextPath() + "/access-denied.jsp");
            return;
        }

        if (uri.contains("/employee") && !"EMPLOYEE".equals(role)) {
            response.sendRedirect(request.getContextPath() + "/access-denied.jsp");
            return;
        }

        chain.doFilter(request, response);
    }
}