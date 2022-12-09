package com.example.AutoGrad.Services.Impl;

import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.Services.IInstructorService;
import com.example.AutoGrad.Services.dto.ChangePasswordDTO;
import com.example.AutoGrad.Services.dto.UserDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InstructorService implements IInstructorService {
    @Lazy
    private Connection connection = com.example.AutoGrad.Services.Connection.getInstance();

    @Lazy
    private Utilities passwordUtilities = new Utilities();

    @Override
    public ResponseEntity updateInstructor(UserDTO userDTO) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getUserById(?)}");
            statement.setInt(1, userDTO.getUserId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
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

    public ResponseEntity updatePassword(ChangePasswordDTO data) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getUserById(?)}");
            statement.setInt(1, data.getUserId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String passInDB = resultSet.getString("user_password");
                String oldPass = data.getOldPassword();
                if(passwordUtilities.matchPassword(oldPass, passInDB)){
                    statement = connection.prepareStatement("{CALL updatePassword(?,?)}");
                    statement.setInt(1, data.getUserId());
                    statement.setString(2, passwordUtilities.generateHash(data.getNewPassword()));
                    statement.execute();
                    return ResponseEntity.ok().body("Password changed successfully");
                } else{
                    throw new Exception("Invalid credentials");
                }
            } else {
                throw new Exception("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
