package com.example.AutoGrad.dataLayer.mock;

import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.Model.dto.ChangePasswordDTO;
import com.example.AutoGrad.Model.dto.LoginDTO;
import com.example.AutoGrad.Model.dto.UserDTO;

public interface IUserDAO {
    public User getUserByEmail(String userEmail);
    public User getUserById(int userId);
   // public double getScoreByUserId(int userId);
    public void updateScoreByUserId(double score, int userId);
    public User addUser(UserDTO userDTO);
    public User updateInstructor(UserDTO userDTO);
    public int getNumberOfProblemSolvedByUser(int userId);
    public User updatePassword(ChangePasswordDTO data);

    User activateAccount(String token);

    User login(LoginDTO credentials);

    double getScoreByUserId(int userId);
}
