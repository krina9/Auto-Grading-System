package com.example.AutoGrad.dataLayer;

import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.Model.dto.ChangePasswordDTO;
import com.example.AutoGrad.Model.dto.UserDTO;
public interface IUser {
    User getUserByEmail(String user_email);
    User getUserById(int userId);
    double getScoreByUserId(int userId);
    void updateScoreByUserId(double score, int userId);
    User addUser(UserDTO userDTO);
    User updatePassword(ChangePasswordDTO data);
    User updateUser(UserDTO userDTO);
    int getNumberOfProblemSolvedByUser(int userId);
}
