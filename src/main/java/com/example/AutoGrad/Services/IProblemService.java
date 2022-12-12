package com.example.AutoGrad.Services;

import com.example.AutoGrad.Model.Problem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProblemService {

    Problem addProblem(Problem problem);

    List<Problem> getAllProblems();

    Problem getProblemById(int problemId);

    List<Problem> getAllProblemByUser(int userId);
}
