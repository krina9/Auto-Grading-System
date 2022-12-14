package com.example.AutoGrad.Model;

import com.example.AutoGrad.Model.dto.ChangePasswordDTO;
import com.example.AutoGrad.dataLayer.IAuthentication;
import com.example.AutoGrad.Model.dto.LoginDTO;
import com.example.AutoGrad.Model.dto.UserDTO;
import com.example.AutoGrad.dataLayer.IUser;
import com.example.AutoGrad.dataLayer.dao.UserDAO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User implements IUser, IAuthentication {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Authority role;
    private Date registeredOn;
    private Boolean isActivated;

    private UserDAO userDAO;
    public User(){

    }

    public User(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public User(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.isActivated = false;
        this.role = userDTO.getRole();
    }

    @Override
    public User getUserByEmail(String userEmail) {
        return userDAO.getUserByEmail(userEmail);
    }

    @Override
    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    public double getScoreByUserId(int userId) {
        return userDAO.getScoreByUserId(userId);
    }

    @Override
    public void updateScoreByUserId(double score, int userId) {
        userDAO.updateScoreByUserId(score, userId);
    }

    @Override
    public User addUser(UserDTO userDTO) {
        try {
            User userInDB = userDAO.getUserByEmail(userDTO.getEmail());
            if (userInDB != null) {
                throw new Exception("User already exist");
            } else {
                return userDAO.addUser(userDTO);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User activateAccount(String token) {
        return userDAO.activateAccount(token);
    }

    @Override
    public User login(LoginDTO credentials) {
        return userDAO.login(credentials);
    }

    @Override
    public User updateUser(UserDTO userDTO) {
        return userDAO.updateInstructor(userDTO);
    }

    @Override
    public int getNumberOfProblemSolvedByUser(int userId) {
        return userDAO.getNumberOfProblemSolvedByUser(userId);
    }

    @Override
    public User updatePassword(ChangePasswordDTO data) {
        return userDAO.updatePassword(data);
    }
}
