package com.example.AutoGrad.Controllers;

import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.dataLayer.IAuthentication;
import com.example.AutoGrad.Model.dto.ChangePasswordDTO;
import com.example.AutoGrad.Model.dto.LoginDTO;
import com.example.AutoGrad.Model.dto.UserDTO;
import com.example.AutoGrad.dataLayer.IUser;
import com.example.AutoGrad.dataLayer.dao.UserDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {

    UserDAO userDAO = new UserDAO();

    IAuthentication authenticationService = new User(userDAO);

    IUser userService = new User(userDAO);

    @GetMapping("/api/confirm-account")
    public ResponseEntity activate(@RequestParam("token") String token) {
        User user = authenticationService.activateAccount(token);
        if(user!=null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/signup")
    public ResponseEntity signup(@RequestBody UserDTO userDTO) {
        User user = userService.addUser(userDTO);
        if(user != null) {
            return ResponseEntity.ok().body(user);
        } else{
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping("/api/login")
    public ResponseEntity login(@RequestBody LoginDTO credentials) {
        User user = authenticationService.login(credentials);
        if(user!=null){
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
