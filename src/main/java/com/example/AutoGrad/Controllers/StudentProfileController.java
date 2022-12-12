package com.example.AutoGrad.Controllers;

import com.example.AutoGrad.Services.IStudentProfileService;
import com.example.AutoGrad.Services.Impl.StudentProfileService;
import com.example.AutoGrad.Services.dto.ChangePasswordDTO;
import com.example.AutoGrad.Services.dto.UserDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentProfileController {

    @Lazy
    private IStudentProfileService studentProfileService = new StudentProfileService();

    @PostMapping("/api/updateStudentProfile")
    public ResponseEntity updateStudentProfile(@RequestBody UserDTO userDTO) {
        return studentProfileService.updateStudentProfile(userDTO);
    }

    @PostMapping("/api/updateStudentPassword")
    public ResponseEntity updatePassword(@RequestBody ChangePasswordDTO data) {
        return studentProfileService.updatePassword(data);
    }
}