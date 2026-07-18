package com.praveen.backend.dao;

import com.praveen.backend.model.Role;
import com.praveen.backend.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {

    /**
     * Retrieves all roles from the database.
     */
    public List<Role> getAllRoles() {

        List<Role> roleList = new ArrayList<>();

        String sql = "SELECT role_id, role_name FROM roles ORDER BY role_id";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {

            while (resultSet.next()) {

                Role role = new Role();

                role.setRoleId(resultSet.getInt("role_id"));
                role.setRoleName(resultSet.getString("role_name"));

                roleList.add(role);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return roleList;
    }

}