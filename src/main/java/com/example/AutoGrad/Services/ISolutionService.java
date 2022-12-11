package com.example.AutoGrad.Services;

import com.example.AutoGrad.Model.Solutions;
import com.example.AutoGrad.Model.TestCases;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface ISolutionService {

    Solutions addSolution(int userId, int problemId, MultipartFile file) throws Exception;

    int compileAndRun(String[] cmd, String output) throws Exception;

    int evaluate(List<TestCases> testCases, File file) throws Exception;

    List<Solutions> getAllSolutions();

    List<Solutions> getSolutionsByUserId(int userId);

    List<Solutions> getSolutionsByUserIdAndProblemId(int userId, int problemId);
}
