package com.example.AutoGrad.Model;

import com.example.AutoGrad.Services.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Authority role;
    private Date registeredOn;
    private Boolean isActivated;
    public User(){

    }
    public User(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.role = userDTO.getRole();
        this.password = userDTO.getPassword();
        this.isActivated = false;
    }
}
