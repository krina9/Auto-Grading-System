package com.example.AutoGrad.dataLayer.mock.implementation;

import com.example.AutoGrad.Model.Authority;
import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.Model.dto.ChangePasswordDTO;
import com.example.AutoGrad.Model.dto.LoginDTO;
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
        return 10;
    }

    @Override
    public void updateScoreByUserId(double score, int userId) {
       User user=new User();

    }

    @Override
    public User addUser(UserDTO userDTO) {
        User user = new User(2,"trusha","shah","trusha@gmail.com","t123",Authority.STUDENT);
        return user;
    }

    @Override
    public User updateInstructor(UserDTO userDTO) {
        User user = new User(2,"Anay","Awasti","ria@gmail.com","r123",Authority.FACULTY);
        return user;
    }

    @Override
    public int getNumberOfProblemSolvedByUser(int userId) {
        return 5;
    }

    @Override
    public User updatePassword(ChangePasswordDTO data) {
        return null;
    }

    @Override
    public User activateAccount(String token) {
        return null;
    }

    @Override
    public User login(LoginDTO credentials) {
        return null;
    }
}
