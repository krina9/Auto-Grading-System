package com.example.AutoGrad.Services.Impl;

import com.example.AutoGrad.Model.Authority;
import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.Services.IUserServices;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserServices implements IUserServices {
    @Lazy
    private Connection connection = com.example.AutoGrad.Services.Connection.getInstance();

    @Override
    public ResponseEntity getUserByEmail(String user_email) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getUserByEmail(?)}");
            statement.setString(1, user_email);
            ResultSet resultSet = statement.executeQuery();
            User user = new User();
            if (resultSet.next()) {
                user.setFirstName(resultSet.getString("user_first_name"));
                user.setLastName(resultSet.getString("user_last_name"));
                user.setEmail(resultSet.getString("user_email"));
                user.setIsActivated(resultSet.getBoolean("isActivated"));
                user.setRole(Authority.valueOf(resultSet.getString("authority")));
                return ResponseEntity.ok().body(user);
            } else {
                throw new Exception("User does not exist");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
