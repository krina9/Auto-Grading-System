package com.example.AutoGrad.Services;

import org.springframework.http.ResponseEntity;

public interface IUserServices {
    ResponseEntity getUserByEmail(String user_email);

}
