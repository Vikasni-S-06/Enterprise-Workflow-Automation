package com.praveen.backend.dao;

import com.praveen.backend.model.Department;
import com.praveen.backend.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    private Connection connection;

    public DepartmentDAO() {

        connection = DBConnection.getConnection();

    }

    // ===========================================
    // SAVE DEPARTMENT
    // ===========================================

    public boolean saveDepartment(Department department) {

        String sql =
                "INSERT INTO departments(department_name) VALUES(?)";

        try (

                PreparedStatement ps =
                        connection.prepareStatement(sql)

        ) {

            ps.setString(
                    1,
                    department.getDepartmentName());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    // ===========================================
    // GET ALL DEPARTMENTS
    // ===========================================

    public List<Department> getAllDepartments() {

        List<Department> departments =
                new ArrayList<>();

        String sql =
                "SELECT * FROM departments ORDER BY department_name";

        try (

                PreparedStatement ps =
                        connection.prepareStatement(sql);

                ResultSet rs =
                        ps.executeQuery()

        ) {

            while (rs.next()) {

                Department department =
                        new Department();

                department.setDepartmentId(
                        rs.getInt("department_id"));

                department.setDepartmentName(
                        rs.getString("department_name"));

                departments.add(department);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return departments;

    }
        // ===========================================
    // GET DEPARTMENT BY ID
    // ===========================================

    public Department getDepartmentById(int departmentId) {

        String sql =
                "SELECT * FROM departments WHERE department_id=?";

        try (

                PreparedStatement ps =
                        connection.prepareStatement(sql)

        ) {

            ps.setInt(1, departmentId);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                Department department =
                        new Department();

                department.setDepartmentId(
                        rs.getInt("department_id"));

                department.setDepartmentName(
                        rs.getString("department_name"));

                return department;

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    // ===========================================
    // UPDATE DEPARTMENT
    // ===========================================

    public boolean updateDepartment(Department department) {

        String sql =
                "UPDATE departments SET department_name=? WHERE department_id=?";

        try (

                PreparedStatement ps =
                        connection.prepareStatement(sql)

        ) {

            ps.setString(
                    1,
                    department.getDepartmentName());

            ps.setInt(
                    2,
                    department.getDepartmentId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    // ==========================================
// DELETE DEPARTMENT
// ==========================================

public boolean deleteDepartment(int departmentId) {

    String sql =
            "DELETE FROM departments WHERE department_id=?";

    try (

            PreparedStatement ps =
                    connection.prepareStatement(sql)

    ) {

        ps.setInt(1, departmentId);

        return ps.executeUpdate() > 0;

    }

    catch (SQLIntegrityConstraintViolationException e) {

        return false;

    }

    catch (SQLException e) {

        e.printStackTrace();

    }

    return false;

}
        // ===========================================
    // SEARCH DEPARTMENTS
    // ===========================================

    public List<Department> searchDepartments(String keyword) {

        List<Department> departments =
                new ArrayList<>();

        String sql =
                "SELECT * FROM departments WHERE department_name LIKE ? ORDER BY department_name";

        try (

                PreparedStatement ps =
                        connection.prepareStatement(sql)

        ) {

            ps.setString(
                    1,
                    "%" + keyword + "%");

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Department department =
                        new Department();

                department.setDepartmentId(
                        rs.getInt("department_id"));

                department.setDepartmentName(
                        rs.getString("department_name"));

                departments.add(department);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return departments;

    }

    // ===========================================
    // CHECK DEPARTMENT EXISTS (ADD)
    // ===========================================

    public boolean departmentExists(String departmentName) {

        String sql =
                "SELECT COUNT(*) FROM departments WHERE department_name=?";

        try (

                PreparedStatement ps =
                        connection.prepareStatement(sql)

        ) {

            ps.setString(1, departmentName);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                return rs.getInt(1) > 0;

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    // ===========================================
    // CHECK DEPARTMENT EXISTS (EDIT)
    // ===========================================

    public boolean departmentExists(String departmentName,
                                    int departmentId) {

        String sql =
                "SELECT COUNT(*) FROM departments WHERE department_name=? AND department_id<>?";

        try (

                PreparedStatement ps =
                        connection.prepareStatement(sql)

        ) {

            ps.setString(1, departmentName);

            ps.setInt(2, departmentId);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                return rs.getInt(1) > 0;

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    // ===========================================
    // TOTAL DEPARTMENTS
    // ===========================================

    public int getDepartmentCount() {

        String sql =
                "SELECT COUNT(*) FROM departments";

        try (

                PreparedStatement ps =
                        connection.prepareStatement(sql);

                ResultSet rs =
                        ps.executeQuery()

        ) {

            if (rs.next()) {

                return rs.getInt(1);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return 0;

    }

    // ===========================================
    // PAGINATION
    // ===========================================

    public List<Department> getDepartmentsByPage(int offset,
                                                 int pageSize) {

        List<Department> departments =
                new ArrayList<>();

        String sql =
                "SELECT * FROM departments ORDER BY department_name LIMIT ?, ?";

        try (

                PreparedStatement ps =
                        connection.prepareStatement(sql)

        ) {

            ps.setInt(1, offset);

            ps.setInt(2, pageSize);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Department department =
                        new Department();

                department.setDepartmentId(
                        rs.getInt("department_id"));

                department.setDepartmentName(
                        rs.getString("department_name"));

                departments.add(department);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return departments;

    }

}