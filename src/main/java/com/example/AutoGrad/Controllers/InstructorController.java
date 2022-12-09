package com.example.AutoGrad.Controllers;

import com.example.AutoGrad.Services.IInstructorService;
import com.example.AutoGrad.Services.Impl.InstructorService;
import com.example.AutoGrad.Services.dto.UserDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class InstructorController {
    @Lazy
    private IInstructorService instructorService = new InstructorService();
    @PostMapping("/api/user/update")
    public ResponseEntity update(@RequestBody UserDTO userDTO)
    {
        return instructorService.updateInstructor(userDTO);
    }
}
