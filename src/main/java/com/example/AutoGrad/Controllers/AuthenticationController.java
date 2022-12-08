package com.example.AutoGrad.Controllers;

import com.example.AutoGrad.Services.IAuthenticationService;
import com.example.AutoGrad.Services.Impl.AuthenticationService;
import com.example.AutoGrad.Services.dto.LoginDTO;
import com.example.AutoGrad.Services.dto.UserDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {


    @Lazy
    private IAuthenticationService authenticationService = new AuthenticationService();

    @GetMapping("/api/confirm-account")
    public ResponseEntity activate(@RequestParam("token") String token) {
        return authenticationService.activateAccount(token);
    }

    @PostMapping("/api/signup")
    public ResponseEntity signup(@RequestBody UserDTO userDTO) {
        return authenticationService.addUser(userDTO);
    }


    @PostMapping("/api/login")
    public ResponseEntity login(@RequestBody LoginDTO credentials) {
        return authenticationService.login(credentials);
    }
}
