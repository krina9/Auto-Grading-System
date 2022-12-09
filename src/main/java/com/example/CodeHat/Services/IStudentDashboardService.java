package com.example.CodeHat.Services;

import org.springframework.http.ResponseEntity;

public interface IStudentDashboardService {
    ResponseEntity getStudentById(Integer userId);
}
