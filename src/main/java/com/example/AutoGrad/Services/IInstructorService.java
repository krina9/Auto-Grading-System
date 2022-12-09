package com.example.AutoGrad.Services;
import com.example.AutoGrad.Services.dto.UserDTO;
import org.springframework.http.ResponseEntity;
public interface IInstructorService {
    ResponseEntity updateInstructor(UserDTO userDTO);
}
