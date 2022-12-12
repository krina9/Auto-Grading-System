package com.example.AutoGrad.Services.dto;

import com.example.AutoGrad.Model.Authority;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Authority role;
}
