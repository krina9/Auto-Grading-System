package com.example.CodeHat.Controller;

import com.example.CodeHat.Services.IStudentDashboardService;
import com.example.CodeHat.Services.Impl.StudentDashboardServices;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StudentDashboardController {
    @Lazy
    private IStudentDashboardService StudentDashboardServices = (IStudentDashboardService) new StudentDashboardServices();

    @GetMapping("/api/studentDashboard/{userId}")
    public ResponseEntity getStudentByEmail(@PathVariable Integer userId)
    {
        return StudentDashboardServices.getStudentById(userId);
    }
}
