package com.example.CodeHat.Services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordDTO {
    int userId;
    String oldPassword;
    String newPassword;
}
