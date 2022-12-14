package com.example.AutoGrad.dataLayer;

import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.Model.dto.LoginDTO;
import com.example.AutoGrad.Model.dto.UserDTO;
public interface IAuthentication {
    User addUser(UserDTO user);
    User activateAccount(String token);
    User login(LoginDTO credentials);
}
