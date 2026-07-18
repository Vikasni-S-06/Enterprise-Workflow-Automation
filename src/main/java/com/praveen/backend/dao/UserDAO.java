package com.praveen.backend.dao;

import com.praveen.backend.model.Department;
import com.praveen.backend.model.Role;
import com.praveen.backend.model.User;
import com.praveen.backend.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    /**
     * Fetch a user using email.
     * Used during Login.
     */
    public User getUserByEmail(String email) {

        String sql = """
                SELECT
                    u.*,
                    r.role_name,
                    d.department_name
                FROM users u
                INNER JOIN roles r
                    ON u.role_id = r.role_id
                LEFT JOIN departments d
                    ON u.department_id = d.department_id
                WHERE u.email = ?
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Role role = new Role();
                role.setRoleId(rs.getInt("role_id"));
                role.setRoleName(rs.getString("role_name"));

                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));

                User user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setEmployeeCode(rs.getString("employee_code"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPasswordHash(rs.getString("password_hash"));
                user.setPhone(rs.getString("phone"));
                user.setRole(role);
                user.setDepartment(department);
                user.setStatus(rs.getString("status"));
                user.setJoiningDate(rs.getDate("joining_date"));
                user.setLastLogin(rs.getTimestamp("last_login"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setUpdatedAt(rs.getTimestamp("updated_at"));

                return user;

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

}