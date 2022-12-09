package com.example.AutoGrad.Controllers;

import com.example.AutoGrad.Services.IAuthenticationService;
import com.example.AutoGrad.Services.IInstructorService;
import com.example.AutoGrad.Services.Impl.AuthenticationService;
import com.example.AutoGrad.Services.Impl.InstructorService;
import com.example.AutoGrad.Services.dto.ChangePasswordDTO;
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
    private IInstructorService instructorService = new InstructorService();

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

    @PostMapping("/api/user/change-password")
    public ResponseEntity updatePwd(@RequestBody ChangePasswordDTO data) {
        return instructorService.updatePassword(data);
    }

}
