package com.app.services;

import com.app.db.DatabaseConnection;
import com.app.domain.Supervisor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krist on 07/09/2018.
 */
public class SupervisorService {
    private Connection connection = null;
    PreparedStatement preparedStatement = null;

    public SupervisorService() {
        connection = new DatabaseConnection().getConn();
    }

    public boolean addSupervisor(Supervisor supervisor) {
        boolean success = false;

        try {
            preparedStatement = connection.prepareStatement("insert into supervisor(name) values(?)");
            preparedStatement.setString(1, supervisor.getName());


            if (preparedStatement.executeUpdate() > 0) {
                success = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
    public boolean deleteSupervisor(int id) {
        boolean success = false;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM supervisor WHERE id = ?");
            preparedStatement.setInt(1, id);

            if (preparedStatement.executeUpdate() > 0) {
                success = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    public Supervisor getSupervisor(int id) {

        Supervisor supervisor = new Supervisor();
        try {
            preparedStatement = connection.prepareStatement("select *from supervisor where id = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                supervisor.setId(resultSet.getInt("id"));
                supervisor.setName(resultSet.getString("sname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supervisor;
    }

    public boolean updateSupervisor(Supervisor supervisor) {

        try {
            preparedStatement = connection.prepareStatement("UPDATE supervisor SET sname = ? WHERE id = ?");
            preparedStatement.setString(1, supervisor.getName());
            preparedStatement.setInt(2, supervisor.getId());

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Supervisor> getSupervisorList() {

        ArrayList<Supervisor> supervisorList = new ArrayList();
        Supervisor supervisor = null;

        try {
            preparedStatement = connection.prepareStatement("select *from supervisor");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                supervisor = new Supervisor();

                supervisor.setId(resultSet.getInt("id"));
                supervisor.setName(resultSet.getString("name"));

                supervisorList.add(supervisor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supervisorList;
    }
}
