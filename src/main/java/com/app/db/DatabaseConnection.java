package com.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/microproject";
    private String username = "root";
    private String password = "";
    private Connection connection = null;

    public DatabaseConnection(){

        try{
            // registering jdbc driver
            Class.forName(driver);
            // getting connection object
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully Connected");

        }catch (ClassNotFoundException ce){
            ce.printStackTrace();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    public Connection getConn(){
        return connection;
    }
}
