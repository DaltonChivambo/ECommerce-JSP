package org.shopping.dao;

import org.shopping.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    private Connection connection;
    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    UserDao(Connection connection){
        this.connection = connection;
    }

    public User userLogin(String email, String password){
        User user = null;
        try{
            query = "SELECT * FROM users WHERE email=? and password=?";
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                //Nao retonar o password por questoes de segurança.
                user.setPassword(resultSet.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return user;
    }
}
