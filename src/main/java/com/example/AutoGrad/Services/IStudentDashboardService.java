package com.example.AutoGrad.Services;

import org.springframework.http.ResponseEntity;

public interface IStudentDashboardService {
    ResponseEntity getStudentById(Integer userId);
}
