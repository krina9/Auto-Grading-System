package com.example.AutoGrad.Services.Impl;

import com.example.AutoGrad.Services.IInstructorService;
import com.example.AutoGrad.Services.dto.UserDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InstructorService implements IInstructorService {
    @Lazy
    Connection connection = com.example.AutoGrad.Services.Connection.getInstance();
    @Override
    public ResponseEntity updateInstructor(UserDTO userDTO) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getUserByEmail(?)}");
            statement.setString(1, userDTO.getEmail());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                statement = connection.prepareStatement("{CALL updateInstructorProfile(?,?,?)}");
                statement.setString(1, userDTO.getFirstName());
                statement.setString(2, userDTO.getLastName());
                statement.setString(3, userDTO.getEmail());
                statement.execute();
                return ResponseEntity.accepted().body(userDTO);
            } else {
                throw new Exception("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
