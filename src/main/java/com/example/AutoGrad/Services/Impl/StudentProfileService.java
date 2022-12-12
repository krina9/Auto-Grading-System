package com.example.AutoGrad.Services.Impl;

import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.Services.IStudentProfileService;
import com.example.AutoGrad.Services.dto.ChangePasswordDTO;
import com.example.AutoGrad.Services.dto.UserDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class StudentProfileService implements IStudentProfileService {

    @Lazy
    private Connection connection = com.example.AutoGrad.Services.Connection.getInstance();

    @Lazy
    private Utilities passwordUtilities = new Utilities();

    @Override
    public ResponseEntity updateStudentProfile(UserDTO userDTO) {
        try {
            CallableStatement statement = connection.prepareCall("{CALL getUserById(?)}");
            int userId;
            String firstName, lastName, email, password;

            userId = userDTO.getUserId();
            firstName = userDTO.getFirstName();
            lastName = userDTO.getLastName();
            email = userDTO.getEmail();
            password = userDTO.getPassword();

            statement.setInt("user_id", userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                statement = connection.prepareCall("{CALL updateStudentProfile(?,?,?,?)}");
                statement.setInt("id", userId);
                statement.setString("first_name", firstName);
                statement.setString("last_name", lastName);
                statement.setString("email", email);

                statement.executeQuery();
                User user = new User(userDTO);
                return ResponseEntity.status(201).body(user);
            } else {
                throw new Exception("User does not exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
            String message = "Required parameters are not supplied";
            //throw new Exception(message);
            return ResponseEntity.status(406).body(message);
        }
    }

    public ResponseEntity updatePassword(ChangePasswordDTO data) {
        try {
            CallableStatement statement = connection.prepareCall("{CALL getUserById(?)}");
            statement.setInt("user_id", data.getUserId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String passwordInDB = resultSet.getString("user_password");
                String userEnteredOldPass = data.getOldPassword();
                if(passwordUtilities.matchPassword(userEnteredOldPass, passwordInDB)){
                    statement = connection.prepareCall("{CALL updatePassword(?,?)}");
                    statement.setInt("puserId", data.getUserId());
                    statement.setString("password", passwordUtilities.generateHash(data.getNewPassword()));
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
