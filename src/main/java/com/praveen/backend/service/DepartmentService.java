package com.praveen.backend.service;

import com.praveen.backend.model.Department;

import java.util.List;

public interface DepartmentService {

    // ==========================================
    // ADD
    // ==========================================

    boolean saveDepartment(Department department);

    // ==========================================
    // UPDATE
    // ==========================================

    boolean updateDepartment(Department department);

    // ==========================================
    // DELETE
    // ==========================================

    boolean deleteDepartment(int departmentId);

    // ==========================================
    // GET BY ID
    // ==========================================

    Department getDepartmentById(int departmentId);

    // ==========================================
    // GET ALL
    // ==========================================

    List<Department> getAllDepartments();

    // ==========================================
    // SEARCH
    // ==========================================

    List<Department> searchDepartments(String keyword);

    // ==========================================
    // PAGINATION
    // ==========================================

    List<Department> getDepartmentsByPage(int offset,
                                          int pageSize);

    // ==========================================
    // COUNT
    // ==========================================

    int getDepartmentCount();

    // ==========================================
    // VALIDATION
    // ==========================================

    boolean departmentExists(String departmentName);

    boolean departmentExists(String departmentName,
                             int departmentId);

}