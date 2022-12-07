package com.example.AutoGrad.Services.Impl;

import com.example.AutoGrad.Model.EmailConfirmation;
import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.Services.IAuthenticationService;
import com.example.AutoGrad.Services.IMailService;
import com.example.AutoGrad.Services.IUtilities;
import com.example.AutoGrad.Services.dto.LoginDTO;
import com.example.AutoGrad.Services.dto.UserDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import java.sql.*;

public class AuthenticationService implements IAuthenticationService {

    @Lazy
    private Connection connection = com.example.AutoGrad.Services.Connection.getInstance();
    @Lazy
    private IMailService mailService = new MailService();

    @Lazy
    IUtilities passwordUtilities = new Utilities();

    @Override
    public ResponseEntity addUser(UserDTO userDTO) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getUserByEmail(?)}");
            statement.setString(1, userDTO.getEmail());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                throw new Exception("User already exists");
            }
            statement = connection.prepareStatement("{CALL addUser(?,?,?,?,?,?,?)}", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userDTO.getFirstName());
            statement.setString(2, userDTO.getLastName());
            statement.setString(3, userDTO.getEmail());
            statement.setString(4, passwordUtilities.generateHash(userDTO.getPassword()));
            statement.setString(5, userDTO.getRole().toString());
            statement.setDate(6, new Date(System.currentTimeMillis()));
            statement.setBoolean(7, false);
            statement.executeQuery();
            System.out.println("User created successfully");

            statement = connection.prepareStatement("{CALL getUserByEmail(?)}");
            statement.setString(1, userDTO.getEmail());
            resultSet = statement.executeQuery();
            int userIdGenerated = -1;
            if(resultSet.next()) {
                userIdGenerated = resultSet.getInt("id");
                System.out.println("USER ID: " + userIdGenerated);
            }
            User user = new User(userDTO);

            EmailConfirmation emailConfirmation = new EmailConfirmation(user);
            statement = connection.prepareCall("{CALL addToken(?,?,?)}");
            statement.setString(1, emailConfirmation.getConfirmationToken());
            statement.setDate(2, emailConfirmation.getDate());
            statement.setInt(3, userIdGenerated);
            statement.executeQuery();
            mailService.sendRegistrationMail(user.getEmail(), emailConfirmation.getConfirmationToken());


            user.setRegisteredOn(new Date(System.currentTimeMillis()));
            return ResponseEntity.status(201).body(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseEntity activateAccount(String token) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getUserIdByToken(?)}", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, token);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String userId = resultSet.getString("user_id");
                statement = connection.prepareCall("{CALL activateUserById(?)}");
                statement.setInt(1, Integer.parseInt(userId));
                statement.executeQuery();

                statement = connection.prepareStatement("{CALL getUserById(?)}", Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, Integer.parseInt(userId));
                resultSet = statement.executeQuery();
                if(resultSet.next()) {
                    mailService.sendActivationMail(resultSet.getString("user_email"));
                }
                return ResponseEntity.ok().build();
            }
            throw new Exception("User not found");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity login(LoginDTO credentials) {
        try {
            CallableStatement statement = connection.prepareCall("{CALL getUserByEmail(?)}");
            statement.setString("user_email", credentials.getEmail());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String dbPassword = resultSet.getString("user_password");
                if (passwordUtilities.matchPassword(credentials.getPassword(), dbPassword)) {
                    return ResponseEntity.accepted().build();
                } else {
                    throw new Exception("Invalid credentials");
                }
            } else {
                throw new Exception("No user found");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
