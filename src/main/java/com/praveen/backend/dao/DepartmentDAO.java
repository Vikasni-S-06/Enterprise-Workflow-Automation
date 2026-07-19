package com.praveen.backend.dao;

import com.praveen.backend.model.Department;
import com.praveen.backend.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    public List<Department> getAllDepartments() {

        List<Department> departments = new ArrayList<>();

        String sql = """
                SELECT *
                FROM departments
                ORDER BY department_name
                """;

        try (

                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()

        ) {

            while (rs.next()) {

                Department department = new Department();

                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));

                departments.add(department);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return departments;

    }

}