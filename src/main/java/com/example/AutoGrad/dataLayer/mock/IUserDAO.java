package com.example.AutoGrad.dataLayer.mock;

import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.Model.dto.ChangePasswordDTO;
import com.example.AutoGrad.Model.dto.UserDTO;

public interface IUserDAO {
    public User getUserByEmail(String userEmail);
    public User getUserById(int userId);
    public double getScoreByUserId(int userId);
    public void updateScoreByUserId(double score, int userId);
    public User addUser(UserDTO userDTO);
    public User updateUser(UserDTO userDTO);
    public int getNumberOfProblemSolvedByUser(int userId);
    public User updatePassword(ChangePasswordDTO data);
}
