package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.config.MySQLConnection;
import com.model.uses;
public class usesRepository {
    public List<uses> getUserByUsernameAndPasswd(String email, String password){
        List<uses> list= new ArrayList<>();

        Connection connection = MySQLConnection.getConnection();
        String query = "select * from uses where email= ? and password = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                uses user = new uses();
                user.setId(resultSet.getInt("id"));
                user.setFullname(resultSet.getString("fullname"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setPasswd(resultSet.getString("password"));
                list.add(user);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return list;
    }

}
