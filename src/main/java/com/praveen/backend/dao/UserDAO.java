package com.praveen.backend.dao;

import com.praveen.backend.model.Department;
import com.praveen.backend.model.Role;
import com.praveen.backend.model.User;
import com.praveen.backend.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    /**
     * Maps a ResultSet row to a User object.
     */
    private User mapUser(ResultSet rs) throws SQLException {

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

    /**
     * Fetch user by email.
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
                return mapUser(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Fetch user by ID.
     */
    public User getUserById(int userId) {

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
                WHERE u.user_id = ?
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapUser(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Retrieve all users.
     */
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

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
                ORDER BY user_id
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {
                users.add(mapUser(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * Save a new user.
     */
    public boolean saveUser(User user) {

        String sql = """
                INSERT INTO users
                (
                    employee_code,
                    first_name,
                    last_name,
                    email,
                    password_hash,
                    phone,
                    role_id,
                    department_id,
                    status,
                    joining_date
                )
                VALUES
                (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setString(1, user.getEmployeeCode());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPasswordHash());
            ps.setString(6, user.getPhone());
            ps.setInt(7, user.getRole().getRoleId());
            ps.setInt(8, user.getDepartment().getDepartmentId());
            ps.setString(9, user.getStatus());
            ps.setDate(10, user.getJoiningDate());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Update an existing user.
     */
    public boolean updateUser(User user) {

        String sql = """
                UPDATE users
                SET
                    first_name = ?,
                    last_name = ?,
                    email = ?,
                    phone = ?,
                    role_id = ?,
                    department_id = ?,
                    status = ?
                WHERE user_id = ?
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setInt(5, user.getRole().getRoleId());
            ps.setInt(6, user.getDepartment().getDepartmentId());
            ps.setString(7, user.getStatus());
            ps.setInt(8, user.getUserId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Delete a user.
     */
    public boolean deleteUser(int userId) {

        String sql = "DELETE FROM users WHERE user_id = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, userId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Update last login timestamp.
     */
    public boolean updateLastLogin(int userId) {

        String sql = """
                UPDATE users
                SET last_login = CURRENT_TIMESTAMP
                WHERE user_id = ?
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setInt(1, userId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}