package com.example.AutoGrad.dataLayer.mock.implementation;

import com.example.AutoGrad.Model.Authority;
import com.example.AutoGrad.Model.StudentProfile;
import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.Model.dto.ChangePasswordDTO;
import com.example.AutoGrad.Model.dto.UserDTO;
import com.example.AutoGrad.dataLayer.mock.IUserDAO;

public class UserDAOMock implements IUserDAO {
    @Override
    public User getUserByEmail(String userEmail) {
       User user = new User(1,"krina","mistry","krina@gmail.com","k123",Authority.STUDENT);
    return user;
    }

    @Override
    public User getUserById(int userId) {
        User user = new User(2,"ria","mistry","ria@gmail.com","r123",Authority.FACULTY);
        return user;
    }
    @Override
    public double getScoreByUserId(int userId) {
        StudentProfile studentProfile=new StudentProfile();
        studentProfile.setScore(10);
        return 0;
    }

    @Override
    public void updateScoreByUserId(double score, int userId) {

    }

    @Override
    public User addUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public User updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public int getNumberOfProblemSolvedByUser(int userId) {
        return 0;
    }

    @Override
    public User updatePassword(ChangePasswordDTO data) {
        return null;
    }
}
