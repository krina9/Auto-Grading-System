package com.example.CodeHat.Services.dto;

import com.example.CodeHat.Model.Authority;
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
