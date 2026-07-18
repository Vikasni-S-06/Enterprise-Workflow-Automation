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
     * Converts a ResultSet row into a User object.
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
     * Used during login.
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
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return mapUser(resultSet);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    /**
     * Fetch user by user ID.
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
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return mapUser(resultSet);

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

        List<User> userList = new ArrayList<>();

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
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);
                ResultSet resultSet =
                        preparedStatement.executeQuery()
        ) {

            while (resultSet.next()) {

                userList.add(mapUser(resultSet));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return userList;
    }

    /**
     * Update user's last login time.
     */
    public boolean updateLastLogin(int userId) {

        String sql = """
                UPDATE users
                SET last_login = CURRENT_TIMESTAMP
                WHERE user_id = ?
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1, userId);

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

}