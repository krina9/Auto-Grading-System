package com.example.AutoGrad.dataLayer.dao;

import com.example.AutoGrad.Model.Authority;
import com.example.AutoGrad.Model.EmailConfirmation;
import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.Model.dto.ChangePasswordDTO;
import com.example.AutoGrad.Services.Connection;
import com.example.AutoGrad.Services.IMailService;
import com.example.AutoGrad.Services.Impl.MailService;
import com.example.AutoGrad.Services.Impl.Utilities;
import com.example.AutoGrad.Model.dto.LoginDTO;
import com.example.AutoGrad.Model.dto.UserDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import java.sql.*;

public class UserDAO {

    @Lazy
    private java.sql.Connection connection = Connection.getInstance();

    private IMailService mailService = new MailService();

    private Utilities passwordUtilities = new Utilities();

    public User getUserByEmail(String userEmail) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getUserByEmail(?)}");
            statement.setString(1, userEmail);
            ResultSet resultSet = statement.executeQuery();
            User user = makeUserFromResultSet(resultSet);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUserById(int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getUserById(?)}");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            User user = makeUserFromResultSet(resultSet);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private User makeUserFromResultSet(ResultSet resultSet) throws Exception {
        User user = null;
        if (resultSet.next()) {
            user = new User();
            user.setUserId(resultSet.getInt(1));
            user.setFirstName(resultSet.getString(2));
            user.setLastName(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));
            user.setRole(Authority.valueOf(resultSet.getString(6)));
            user.setRegisteredOn(resultSet.getDate(7));
            user.setIsActivated(resultSet.getBoolean(8));
            return user;
        } else {
            return null;
        }
    }

    public double getScoreByUserId(int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getScoreByUserId(?)}");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("score");
            } else {
                throw new Exception("User not found");
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

    public User addUser(UserDTO userDTO) {
        try {

            PreparedStatement statement = connection.prepareStatement("{CALL addUser(?,?,?,?,?,?,?)}", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userDTO.getFirstName());
            statement.setString(2, userDTO.getLastName());
            statement.setString(3, userDTO.getEmail());
            statement.setString(4, passwordUtilities.generateHash(userDTO.getPassword()));
            statement.setString(5, userDTO.getRole().toString());
            statement.setDate(6, new Date(System.currentTimeMillis()));
            statement.setBoolean(7, false);
            statement.executeQuery();
            System.out.println("User created successfully");

            User user = getUserByEmail(userDTO.getEmail());

            EmailConfirmation emailConfirmation = new EmailConfirmation(user);
            statement = connection.prepareCall("{CALL addToken(?,?,?)}");
            statement.setString(1, emailConfirmation.getConfirmationToken());
            statement.setDate(2, emailConfirmation.getDate());
            statement.setInt(3, user.getUserId());
            statement.executeQuery();
            mailService.sendRegistrationMail(user.getEmail(), emailConfirmation.getConfirmationToken());

            user.setRegisteredOn(new Date(System.currentTimeMillis()));
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User activateAccount(String token) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getUserIdByToken(?)}", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, token);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int userId = Integer.parseInt(resultSet.getString("user_id"));
                statement = connection.prepareCall("{CALL activateUserById(?)}");
                statement.setInt(1, userId);
                statement.executeQuery();

                User user = getUserById(userId);
                if (user != null) {
                    mailService.sendActivationMail(user.getEmail());
                }
                return user;
            }
            throw new Exception("User not found");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User login(LoginDTO credentials) {
        try {
            CallableStatement statement = connection.prepareCall("{CALL getUserByEmail(?)}");
            statement.setString("user_email", credentials.getEmail());
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                String dbPassword = resultSet.getString("user_password");
                if (passwordUtilities.matchPassword(credentials.getPassword(), dbPassword)) {
                    user = getUserByEmail(credentials.getEmail());
                    return user;
                } else {
                    throw new Exception("Invalid credentials");
                }
            } else {
                throw new Exception("No user found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User updateInstructor(UserDTO userDTO) {
        try {
            User user = getUserById(userDTO.getUserId());
            if (user != null) {
                PreparedStatement statement = connection.prepareStatement("{CALL updateUser(?,?,?)}");
                statement.setString(1, userDTO.getFirstName());
                statement.setString(2, userDTO.getLastName());
                statement.setInt(3, userDTO.getUserId());
                statement.execute();
                return getUserByEmail(user.getEmail());
            } else {
                throw new Exception("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User updatePassword(ChangePasswordDTO data) {
        try {

            User user = getUserById(data.getUserId());
            if (user != null) {

                    String passInDB = user.getPassword();
                    String oldPass = data.getOldPassword();
                    if (passwordUtilities.matchPassword(oldPass, passInDB)) {
                        PreparedStatement statement = connection.prepareStatement("{CALL updatePassword(?,?)}");
                        statement.setInt(1, data.getUserId());
                        statement.setString(2, passwordUtilities.generateHash(data.getNewPassword()));
                        statement.execute();
                        return getUserById(user.getUserId());
                    } else {
                        throw new Exception("Invalid credentials");
                    }
            } else {
                throw new Exception("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getNumberOfProblemSolvedByUser(int userId) {
        try{
            PreparedStatement statement = connection.prepareStatement("{CALL getProblemSolvedByUserId(?)}");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
