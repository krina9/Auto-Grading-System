package com.example.CodeHat.Model;

import com.example.CodeHat.Services.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Authority role;
    private Date registeredOn;
    private Boolean isActivated;

    public User(UserDTO userDTO) {
        this.userId = userDTO.getUserId();
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.role = userDTO.getRole();
        this.password = userDTO.getPassword();
        this.isActivated = false;
    }
}