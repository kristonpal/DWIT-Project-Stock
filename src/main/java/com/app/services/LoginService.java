package com.app.services;

import com.app.domain.User;
import com.app.db.DatabaseConnection;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginService {

    private Connection connection =null;
    private PreparedStatement preparedStatement;

    public LoginService(){
        connection = new DatabaseConnection().getConn();
    }

    public boolean authenticate(User user){

        try {
            preparedStatement = connection.prepareStatement("select *from user WHERE username=? AND password = ?");
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                return true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    public static String getPasswordHashed(String password){
        String generatedPassword = null;

        try {
            // create MessageDigest instance for MD5
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // Add password bytes to digest
            md5.update(password.getBytes());
            // Get the hash's bytes
            byte[] bytes = md5.digest();
            // This bytes has bytes in decimal format
            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
            }

            // Get the complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return generatedPassword;
    }
}
