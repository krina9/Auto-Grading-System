package com.example.AutoGrad.Services.Impl;

import com.example.AutoGrad.Model.Authority;
import com.example.AutoGrad.Model.User;
import org.springframework.context.annotation.Lazy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {

    @Lazy
    private Connection connection = com.example.AutoGrad.Services.Connection.getInstance();

    public User getUserById(int userId) throws Exception{
        try{
            PreparedStatement statement = connection.prepareStatement("{CALL getUserById(?)}");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setEmail(resultSet.getString("user_email"));
                user.setFirstName(resultSet.getString("user_first_name"));
                user.setLastName(resultSet.getString("user_last_name"));
                user.setRole(Authority.valueOf(resultSet.getString("authority")));
                return user;
            }
            throw new Exception("User not found");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public double getScoreByUserId(int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getScoreByUserId(?)}");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getInt("score");
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void updateScoreByUserId(double score, int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL updateScoreByUserId(?, ?)}");
            statement.setDouble(1, score);
            statement.setInt(2, userId);
            statement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
