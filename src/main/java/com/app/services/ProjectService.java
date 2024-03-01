package com.app.services;

import com.app.db.DatabaseConnection;
import com.app.domain.Project;
import com.app.domain.User;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {

    private static final String tableName = "project";

    public List<Project> getProjectList () {

        Connection connection  = new DatabaseConnection().getConn();
        PreparedStatement preparedStatement = null;

        ArrayList<Project> projectList = new ArrayList();
        Project project = null;

        try {
            preparedStatement = connection.prepareStatement(
                    "select *from project"
            );

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                project = new Project();

                project.setId(resultSet.getInt("id"));
                project.setRoll(resultSet.getInt("roll"));
                project.setName(resultSet.getString("name"));
                project.setYear(resultSet.getInt("year"));
                project.setSemester(resultSet.getString("semester"));
                project.setCategory(resultSet.getString("category"));
                project.setFilename(resultSet.getString("filename"));
                project.setTitle(resultSet.getString("title"));
                project.setTags(resultSet.getString("tags"));
                project.setSupervisor(resultSet.getString("supervisor"));
                project.setDomain(resultSet.getString("domain"));
                project.setAbstraction(resultSet.getString("abstraction"));
//                project.setAdvisers(resultSet.getString("advisers"));

//                project.setFile(resultSet.getBlob("file"));

                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projectList;
    }

    public void insertProject(Project project) {

        Connection connection = new DatabaseConnection().getConn();
        PreparedStatement preparedStatement = null;

        String query = "insert into project (`roll`,`name`,`year`,`semester`,`category`,`filename`,`title`,`tags`,`supervisor`,`domain`,`abstraction`) values(?,?,?,?,?,?,?,?,?,?,?)";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,project.getRoll());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setInt(3,project.getYear());
            preparedStatement.setString(4,project.getSemester());
            preparedStatement.setString(5, project.getCategory());
            preparedStatement.setString(6, project.getFilename());
            preparedStatement.setString(7, project.getTitle());
            preparedStatement.setString(8, project.getTags());
            preparedStatement.setString(9,project.getSupervisor());
            preparedStatement.setString(10,project.getDomain());
            preparedStatement.setString(11, project.getAbstraction());
//            pstm.setBlob(6,project.getFile());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public boolean insertProjectWithFile(Project project, InputStream inputStream) {

        Connection connection = new DatabaseConnection().getConn();
        PreparedStatement preparedStatement = null;

        String query = "insert into "+ tableName +" (`roll`,`name`,`year`,`semester`,`category`,`filename`,`title`,`tags`,`supervisor`,`domain`,`abstraction`, `file`) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,project.getRoll());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setInt(3,project.getYear());
            preparedStatement.setString(4,project.getSemester());
            preparedStatement.setString(5, project.getCategory());
            preparedStatement.setString(6, project.getFilename());
            preparedStatement.setString(7, project.getTitle());
            preparedStatement.setString(8, project.getTags());
            preparedStatement.setString(9,project.getSupervisor());
            preparedStatement.setString(10,project.getDomain());
            preparedStatement.setString(11, project.getAbstraction());

            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                preparedStatement.setBlob(12, inputStream);
            }

            int value = preparedStatement.executeUpdate();

            System.out.println("+++++++++++++++++ " +  value);

            if (value > 0){
                System.out.println("File uploaded and saved in database");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }


    public Project getProjectById (String id) {

        Connection connection  = new DatabaseConnection().getConn();
        PreparedStatement preparedStatement = null;
        Project project = new Project();

        try {
            preparedStatement = connection.prepareStatement(
                    "select *from project WHERE id = ?"
            );
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                project = new Project();

                project.setId(resultSet.getInt("id"));
                project.setRoll(resultSet.getInt("roll"));
                project.setName(resultSet.getString("name"));
                project.setYear(resultSet.getInt("year"));
                project.setSemester(resultSet.getString("semester"));
                project.setCategory(resultSet.getString("category"));
                project.setFilename(resultSet.getString("filename"));
                project.setTitle(resultSet.getString("title"));
                project.setTags(resultSet.getString("tags"));
                project.setSupervisor(resultSet.getString("supervisor"));
                project.setDomain(resultSet.getString("domain"));
                project.setAbstraction(resultSet.getString("abstraction"));
                project.setFile(resultSet.getBlob("file"));
            }
            return project;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }






}
