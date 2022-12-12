package com.example.AutoGrad.Services;

import com.example.AutoGrad.Services.dto.ChangePasswordDTO;
import com.example.AutoGrad.Services.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface IStudentProfileService {

    ResponseEntity updateStudentProfile(UserDTO userDTO);
    ResponseEntity updatePassword(ChangePasswordDTO data);

}
