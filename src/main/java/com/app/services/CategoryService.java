package com.app.services;

import com.app.db.DatabaseConnection;
import com.app.domain.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by krist on 27/08/2018.
 */
public class CategoryService {
    private Connection connection = null;
    PreparedStatement preparedStatement = null;

    public CategoryService() {
        connection = new DatabaseConnection().getConn();
    }

    public boolean addCategory(Category category) {
        boolean success = false;

        try {
            preparedStatement = connection.prepareStatement("insert into category(name) values(?)");
            preparedStatement.setString(1, category.getName());


            if (preparedStatement.executeUpdate() > 0) {
                success = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
    public boolean deleteCategory(int id) {
        boolean success = false;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM category WHERE id = ?");
            preparedStatement.setInt(1, id);

            if (preparedStatement.executeUpdate() > 0) {
                success = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public Category getCategory(int id) {

        Category category = new Category();
        try {
            preparedStatement = connection.prepareStatement("select *from category where id = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;
    }

    public boolean updateCategory(Category category) {

        try {
            preparedStatement = connection.prepareStatement("UPDATE category SET name = ? where id = ?");
            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, category.getId());

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Category> getCategoryList() {

        ArrayList<Category> categoryList = new ArrayList();
        Category category = null;

        try {
            preparedStatement = connection.prepareStatement("select *from category");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                category = new Category();

                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));

                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoryList;
    }
}
