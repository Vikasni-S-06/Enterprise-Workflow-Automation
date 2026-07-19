package com.praveen.backend.service;

import com.praveen.backend.dao.DepartmentDAO;
import com.praveen.backend.model.Department;

import java.util.List;

public class DepartmentServiceImpl
        implements DepartmentService {

    private final DepartmentDAO departmentDAO =
            new DepartmentDAO();

    // ==========================================
    // SAVE DEPARTMENT
    // ==========================================

    @Override
    public boolean saveDepartment(
            Department department) {

        return departmentDAO
                .saveDepartment(department);

    }

    // ==========================================
    // UPDATE DEPARTMENT
    // ==========================================

    @Override
    public boolean updateDepartment(
            Department department) {

        return departmentDAO
                .updateDepartment(department);

    }

    // ==========================================
    // DELETE DEPARTMENT
    // ==========================================

    @Override
    public boolean deleteDepartment(
            int departmentId) {

        return departmentDAO
                .deleteDepartment(departmentId);

    }

    // ==========================================
    // GET DEPARTMENT BY ID
    // ==========================================

    @Override
    public Department getDepartmentById(
            int departmentId) {

        return departmentDAO
                .getDepartmentById(departmentId);

    }

    // ==========================================
    // GET ALL DEPARTMENTS
    // ==========================================

    @Override
    public List<Department> getAllDepartments() {

        return departmentDAO
                .getAllDepartments();

    }

    // ==========================================
    // SEARCH DEPARTMENTS
    // ==========================================

    @Override
    public List<Department> searchDepartments(
            String keyword) {

        return departmentDAO
                .searchDepartments(keyword);

    }

    // ==========================================
    // PAGINATION
    // ==========================================

    @Override
    public List<Department> getDepartmentsByPage(
            int offset,
            int pageSize) {

        return departmentDAO
                .getDepartmentsByPage(
                        offset,
                        pageSize);

    }

    // ==========================================
    // TOTAL DEPARTMENTS
    // ==========================================

    @Override
    public int getDepartmentCount() {

        return departmentDAO
                .getDepartmentCount();

    }

    // ==========================================
    // DUPLICATE CHECK (ADD)
    // ==========================================

    @Override
    public boolean departmentExists(
            String departmentName) {

        return departmentDAO
                .departmentExists(departmentName);

    }

    // ==========================================
    // DUPLICATE CHECK (EDIT)
    // ==========================================

    @Override
    public boolean departmentExists(
            String departmentName,
            int departmentId) {

        return departmentDAO
                .departmentExists(
                        departmentName,
                        departmentId);

    }

}