package com.example.CodeHat.Services;

import com.example.CodeHat.Services.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface IStudentProfileService {

    ResponseEntity updateStudentProfile(UserDTO userDTO);

}
