package com.praveen.backend.servlet;

import com.praveen.backend.model.Department;
import com.praveen.backend.service.DepartmentService;
import com.praveen.backend.service.DepartmentServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/departments")
public class DepartmentServlet extends HttpServlet {

    private final DepartmentService departmentService =
            new DepartmentServiceImpl();

    private static final int PAGE_SIZE = 10;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String page =
                request.getParameter("page");

        String action =
                request.getParameter("action");

        // ==========================================
        // ADD PAGE
        // ==========================================

        if ("add".equals(page)) {

            request.getRequestDispatcher(
                    "/admin/departments/add.jsp")
                    .forward(request, response);

            return;

        }

        // ==========================================
        // VIEW DEPARTMENT
        // ==========================================

        if ("view".equals(action)) {

            int departmentId =
                    Integer.parseInt(
                            request.getParameter("id"));

            Department department =
                    departmentService.getDepartmentById(
                            departmentId);

            request.setAttribute(
                    "department",
                    department);

            request.getRequestDispatcher(
                    "/admin/departments/view.jsp")
                    .forward(request, response);

            return;

        }

        // ==========================================
        // EDIT PAGE
        // ==========================================

        if ("edit".equals(action)) {

            int departmentId =
                    Integer.parseInt(
                            request.getParameter("id"));

            Department department =
                    departmentService.getDepartmentById(
                            departmentId);

            request.setAttribute(
                    "department",
                    department);

            request.getRequestDispatcher(
                    "/admin/departments/edit.jsp")
                    .forward(request, response);

            return;

        }

        // ==========================================
        // DELETE DEPARTMENT
        // ==========================================

        if ("delete".equals(action)) {

            int departmentId =
                    Integer.parseInt(
                            request.getParameter("id"));

            boolean deleted =
                    departmentService.deleteDepartment(
                            departmentId);

            if (deleted) {

                response.sendRedirect(
                        request.getContextPath()
                                + "/departments?success=deleted");

            } else {

                response.sendRedirect(
                        request.getContextPath()
                                + "/departments?error=assigned");

            }

            return;

        }
                // ==========================================
        // SEARCH DEPARTMENT
        // ==========================================

        String keyword =
                request.getParameter("keyword");

        if (keyword != null &&
                !keyword.trim().isEmpty()) {

            List<Department> departments =
                    departmentService.searchDepartments(
                            keyword);

            request.setAttribute(
                    "departments",
                    departments);

            request.setAttribute(
                    "keyword",
                    keyword);

            request.getRequestDispatcher(
                    "/admin/departments/list.jsp")
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

        int totalDepartments =
                departmentService.getDepartmentCount();

        int totalPages =
                (int) Math.ceil(
                        (double) totalDepartments
                                / PAGE_SIZE);

        int offset =
                (currentPage - 1)
                        * PAGE_SIZE;

        List<Department> departments =
                departmentService.getDepartmentsByPage(
                        offset,
                        PAGE_SIZE);

        request.setAttribute(
                "departments",
                departments);

        request.setAttribute(
                "currentPage",
                currentPage);

        request.setAttribute(
                "totalPages",
                totalPages);

        request.getRequestDispatcher(
                "/admin/departments/list.jsp")
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
        // UPDATE DEPARTMENT
        // ==========================================

        if ("update".equals(action)) {

            int departmentId =
                    Integer.parseInt(
                            request.getParameter(
                                    "departmentId"));

            String departmentName =
                    request.getParameter(
                            "departmentName");

            if (departmentService.departmentExists(
                    departmentName,
                    departmentId)) {

                Department department =
                        new Department();

                department.setDepartmentId(
                        departmentId);

                department.setDepartmentName(
                        departmentName);

                request.setAttribute(
                        "department",
                        department);

                request.setAttribute(
                        "error",
                        "Department already exists.");

                request.getRequestDispatcher(
                        "/admin/departments/edit.jsp")
                        .forward(request, response);

                return;

            }

            Department department =
                    new Department();

            department.setDepartmentId(
                    departmentId);

            department.setDepartmentName(
                    departmentName);

            boolean updated =
                    departmentService.updateDepartment(
                            department);

            if (updated) {

                response.sendRedirect(
                        request.getContextPath()
                                + "/departments?success=updated");

            } else {

                response.sendRedirect(
                        request.getContextPath()
                                + "/departments?error=update");

            }

            return;

        }
                // ==========================================
        // ADD DEPARTMENT
        // ==========================================

        String departmentName =
                request.getParameter(
                        "departmentName");

        if (departmentService.departmentExists(
                departmentName)) {

            request.setAttribute(
                    "error",
                    "Department already exists.");

            request.setAttribute(
                    "departmentName",
                    departmentName);

            request.getRequestDispatcher(
                    "/admin/departments/add.jsp")
                    .forward(request, response);

            return;

        }

        Department department =
                new Department();

        department.setDepartmentName(
                departmentName);

        boolean saved =
                departmentService.saveDepartment(
                        department);

        if (saved) {

            response.sendRedirect(
                    request.getContextPath()
                            + "/departments?success=added");

        } else {

            response.sendRedirect(
                    request.getContextPath()
                            + "/departments?error=save");

        }

    }

}