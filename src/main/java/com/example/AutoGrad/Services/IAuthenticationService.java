package com.example.AutoGrad.Services;

import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.Services.dto.LoginDTO;
import com.example.AutoGrad.Services.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationService {

    ResponseEntity addUser(UserDTO user);

    ResponseEntity activateAccount(String token);

    ResponseEntity login(LoginDTO credentials);
}
