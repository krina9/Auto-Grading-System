package com.example.CodeHat.Services.Impl;

import com.example.CodeHat.Model.User;
import com.example.CodeHat.Services.IStudentProfileService;
import com.example.CodeHat.Services.dto.UserDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class StudentProfileService implements IStudentProfileService {

    @Lazy
    private Connection connection = com.example.CodeHat.Services.Connection.getInstance();

    @Override
    public ResponseEntity updateStudentProfile(UserDTO userDTO) {
        try {
            CallableStatement statement = connection.prepareCall("{CALL getUserByEmail(?)}");
            statement.setString("user_email", userDTO.getEmail());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                statement = connection.prepareCall("{CALL updateStudentProfile(?,?,?,?)}");
                statement.setString("first_name",userDTO.getFirstName());
                statement.setString("last_name",userDTO.getLastName());
                statement.setString("email", userDTO.getEmail());
                statement.setString("password", userDTO.getPassword());

                resultSet = statement.executeQuery();
                User user = new User(userDTO);
                return ResponseEntity.status(201).body(user);
            }else {
                throw new Exception("User does not exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
