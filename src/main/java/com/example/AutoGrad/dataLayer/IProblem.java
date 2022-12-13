package com.example.AutoGrad.dataLayer;

import com.example.AutoGrad.Model.Problem;

import java.util.List;

public interface IProblem {

    Problem addProblem(Problem problem);

    List<Problem> getAllProblem();

    Problem getProblemById(int problemId);

    List<Problem> getAllProblemByUser(int userId);
}
