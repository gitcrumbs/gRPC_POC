package com.shopping.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UserDao {

    private static final Logger logger = Logger.getLogger(UserDao.class.getName());



    public User getDetails(String username ){

        User user = new User();

        try {
            logger.log(Level.SEVERE, "Connecting to DB....");
            Connection connection = H2DatabaseConnection.getConnectionToDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from `user` where `username`=?");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setGender(resultSet.getString("gender"));

            }
            connection.close();
            logger.log(Level.SEVERE, "DB Connection Closed");
        }catch (Exception e){
                logger.log(Level.SEVERE, "Could not execute query"+e);
        }



        return user;

    }



}
