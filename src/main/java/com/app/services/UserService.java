package com.app.services;

import com.app.domain.User;
import com.app.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserService {

    private Connection connection = null;
    PreparedStatement preparedStatement = null;

    public UserService() {
        connection = new DatabaseConnection().getConn();
    }

    public boolean addUser(User user) {
        boolean success = false;

        try {
            preparedStatement = connection.prepareStatement("insert into user(first_name, last_name, username, password, role) values(?,?,?,?,?)");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());

            if (preparedStatement.executeUpdate() > 0) {
                success = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public boolean deleteUser(int id) {
        boolean success = false;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id = ?");
            preparedStatement.setInt(1, id);

            if (preparedStatement.executeUpdate() > 0) {
                success = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public User getUser(int id) {

        User user = new User();
        try {
            preparedStatement = connection.prepareStatement("select *from user where id = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setUsername(resultSet.getString("username"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean updateUser(User user) {

        try {
            preparedStatement = connection.prepareStatement("UPDATE user SET first_name = ?,last_name = ?,username = ?,password = ?,role = ? where id = ?");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setInt(6, user.getId());

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> getUserList() {

        ArrayList<User> userList = new ArrayList();
        User user = null;

        try {
            preparedStatement = connection.prepareStatement("select *from user");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();

                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setUsername(resultSet.getString("username"));
                user.setRole(resultSet.getString("role"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public boolean checkUser() {
        boolean userExist = false;

        try {

            preparedStatement = connection.prepareStatement("select * from user where username = ?");
            preparedStatement.setString(1, "kri");
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                userExist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userExist;
    }
}
