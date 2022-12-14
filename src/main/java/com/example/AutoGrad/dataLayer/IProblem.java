package com.example.AutoGrad.dataLayer;

import com.example.AutoGrad.Model.Problem;

import java.util.List;

public interface IProblem {

    Problem addProblem(Problem problem);

    Problem getProblemById(int problemId);

    List<Problem> getAllProblemByUser(int userId);

    List<Problem> getAllProblems(int bugFix);
}
