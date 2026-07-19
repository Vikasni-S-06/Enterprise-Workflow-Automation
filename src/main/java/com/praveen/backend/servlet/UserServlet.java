package com.praveen.backend.servlet;

import com.praveen.backend.dao.DepartmentDAO;
import com.praveen.backend.dao.RoleDAO;
import com.praveen.backend.model.Department;
import com.praveen.backend.model.Role;
import com.praveen.backend.model.User;
import com.praveen.backend.service.UserService;
import com.praveen.backend.service.UserServiceImpl;
import com.praveen.backend.util.PasswordUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private final UserService userService =
            new UserServiceImpl();

    private final RoleDAO roleDAO =
            new RoleDAO();

    private final DepartmentDAO departmentDAO =
            new DepartmentDAO();

    private static final int PAGE_SIZE = 10;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String page =
                request.getParameter("page");

        String action =
                request.getParameter("action");

        // ==========================================
        // ADD USER PAGE
        // ==========================================

        if ("add".equals(page)) {

            request.setAttribute(
                    "roles",
                    roleDAO.getAllRoles());

            request.setAttribute(
                    "departments",
                    departmentDAO.getAllDepartments());

            request.getRequestDispatcher(
                    "/admin/users/add.jsp")
                    .forward(request, response);

            return;
        }

        // ==========================================
        // VIEW USER
        // ==========================================

        if ("view".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id"));

            User user =
                    userService.getUserById(id);

            request.setAttribute(
                    "user",
                    user);

            request.getRequestDispatcher(
                    "/admin/users/view.jsp")
                    .forward(request, response);

            return;
        }

        // ==========================================
        // EDIT USER
        // ==========================================

        if ("edit".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id"));

            User user =
                    userService.getUserById(id);

            request.setAttribute(
                    "user",
                    user);

            request.setAttribute(
                    "roles",
                    roleDAO.getAllRoles());

            request.setAttribute(
                    "departments",
                    departmentDAO.getAllDepartments());

            request.getRequestDispatcher(
                    "/admin/users/edit.jsp")
                    .forward(request, response);

            return;
        }

        // ==========================================
        // DELETE USER
        // ==========================================

        if ("delete".equals(action)) {

            int id = Integer.parseInt(
                    request.getParameter("id"));

            userService.deleteUser(id);

            response.sendRedirect(
                    request.getContextPath()
                            + "/users?success=deleted");

            return;
        }

        // ==========================================
        // SEARCH
        // ==========================================

        String keyword =
                request.getParameter("keyword");

        if (keyword != null &&
                !keyword.trim().isEmpty()) {

            List<User> users =
                    userService.searchUsers(keyword);

            request.setAttribute(
                    "users",
                    users);

            request.setAttribute(
                    "keyword",
                    keyword);

            request.getRequestDispatcher(
                    "/admin/users/list.jsp")
                    .forward(request, response);

            return;
        }

        // ==========================================
        // PAGINATION
        // ==========================================

        int currentPage = 1;

        try {

            currentPage =
                    Integer.parseInt(
                            request.getParameter(
                                    "currentPage"));

        } catch (Exception ignored) {
        }

        int totalUsers =
                userService.getUserCount();

        int totalPages =
                (int) Math.ceil(
                        (double) totalUsers
                                / PAGE_SIZE);

        int offset =
                (currentPage - 1)
                        * PAGE_SIZE;

        List<User> users =
                userService.getUsersByPage(
                        offset,
                        PAGE_SIZE);

        request.setAttribute(
                "users",
                users);

        request.setAttribute(
                "currentPage",
                currentPage);

        request.setAttribute(
                "totalPages",
                totalPages);

        request.getRequestDispatcher(
                "/admin/users/list.jsp")
                .forward(request, response);

    }

        @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action =
                request.getParameter("action");

        // ==========================================
        // UPDATE USER
        // ==========================================

        if ("update".equals(action)) {

            int userId = Integer.parseInt(
                    request.getParameter("userId"));

            String email =
                    request.getParameter("email");

            if (userService.emailExistsForAnotherUser(
                    email,
                    userId)) {

                User user =
                        userService.getUserById(userId);

                request.setAttribute(
                        "error",
                        "Email already exists.");

                request.setAttribute(
                        "user",
                        user);

                request.setAttribute(
                        "roles",
                        roleDAO.getAllRoles());

                request.setAttribute(
                        "departments",
                        departmentDAO.getAllDepartments());

                request.getRequestDispatcher(
                        "/admin/users/edit.jsp")
                        .forward(request, response);

                return;
            }

            User user = new User();

            user.setUserId(userId);

            user.setFirstName(
                    request.getParameter("firstName"));

            user.setLastName(
                    request.getParameter("lastName"));

            user.setEmail(email);

            user.setPhone(
                    request.getParameter("phone"));

            user.setStatus(
                    request.getParameter("status"));

            Role role = new Role();

            role.setRoleId(
                    Integer.parseInt(
                            request.getParameter("roleId")));

            user.setRole(role);

            Department department =
                    new Department();

            department.setDepartmentId(
                    Integer.parseInt(
                            request.getParameter("departmentId")));

            user.setDepartment(department);

            boolean updated =
                    userService.updateUser(user);

            if (updated) {

                response.sendRedirect(
                        request.getContextPath()
                                + "/users?success=updated");

            } else {

                response.sendRedirect(
                        request.getContextPath()
                                + "/users?error=update");

            }

            return;
        }

        // ==========================================
        // ADD USER
        // ==========================================

        String employeeCode =
                request.getParameter("employeeCode");

        String email =
                request.getParameter("email");

        if (userService.employeeCodeExists(employeeCode)) {

            request.setAttribute(
                    "error",
                    "Employee Code already exists.");

            request.setAttribute(
                    "roles",
                    roleDAO.getAllRoles());

            request.setAttribute(
                    "departments",
                    departmentDAO.getAllDepartments());

            request.getRequestDispatcher(
                    "/admin/users/add.jsp")
                    .forward(request, response);

            return;
        }

        if (userService.emailExists(email)) {

            request.setAttribute(
                    "error",
                    "Email already exists.");

            request.setAttribute(
                    "roles",
                    roleDAO.getAllRoles());

            request.setAttribute(
                    "departments",
                    departmentDAO.getAllDepartments());

            request.getRequestDispatcher(
                    "/admin/users/add.jsp")
                    .forward(request, response);

            return;
        }

        User user = new User();

        user.setEmployeeCode(employeeCode);

        user.setFirstName(
                request.getParameter("firstName"));

        user.setLastName(
                request.getParameter("lastName"));

        user.setEmail(email);

        user.setPasswordHash(
                PasswordUtil.hashPassword(
                        request.getParameter("password")));

        user.setPhone(
                request.getParameter("phone"));

        Role role = new Role();

        role.setRoleId(
                Integer.parseInt(
                        request.getParameter("roleId")));

        user.setRole(role);

        Department department =
                new Department();

        department.setDepartmentId(
                Integer.parseInt(
                        request.getParameter("departmentId")));

        user.setDepartment(department);

        user.setStatus(
                request.getParameter("status"));

        user.setJoiningDate(
                Date.valueOf(
                        request.getParameter("joiningDate")));

        boolean saved =
                userService.saveUser(user);

        if (saved) {

            response.sendRedirect(
                    request.getContextPath()
                            + "/users?success=added");

        } else {

            request.setAttribute(
                    "error",
                    "Unable to save user.");

            request.setAttribute(
                    "roles",
                    roleDAO.getAllRoles());

            request.setAttribute(
                    "departments",
                    departmentDAO.getAllDepartments());

            request.getRequestDispatcher(
                    "/admin/users/add.jsp")
                    .forward(request, response);

        }

    }

}