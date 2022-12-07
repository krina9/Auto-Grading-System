package com.example.AutoGrad.Controllers;

import com.example.AutoGrad.Services.IAuthenticationService;
import com.example.AutoGrad.Services.IUserServices;
import com.example.AutoGrad.Services.Impl.AuthenticationService;
import com.example.AutoGrad.Services.Impl.UserServices;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    @Lazy
    private IUserServices userServices = new UserServices();

    @GetMapping("/api/user/{user_email}")
    public ResponseEntity getUerByEmail(@PathVariable String user_email)
    {
        return userServices.getUserByEmail(user_email);
    }
}
