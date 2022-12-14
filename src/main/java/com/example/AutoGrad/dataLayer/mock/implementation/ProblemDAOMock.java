package com.example.AutoGrad.dataLayer.mock.implementation;

import com.example.AutoGrad.Model.Problem;
import com.example.AutoGrad.dataLayer.mock.IProblemDAO;

import java.util.ArrayList;
import java.util.List;

public class ProblemDAOMock implements IProblemDAO {
    @Override
    public Problem addProblem(Problem problem) {
        return null;
    }

//    @Override
    public List<Problem> getAllProblem() {
        List<Problem> problemList = new ArrayList<>();
        Problem prob1 = new Problem(
                1,
                "Test Problem",
                "Test Statement",
                5.0f,
                5,
                "easy",
                "numnerical",
                1
        );
        Problem prob2 = new Problem(
                2,
                "Test Problem 2",
                "Test Statement 2",
                10.0f,
                2,
                "mediocre",
                "numnerical",
                1
        );

        problemList.add(prob1);
        problemList.add(prob2);

        return problemList;
    }

    @Override
    public Problem getProblemById(int problemId) {
        Problem prob1 = new Problem();
        return null;
    }

    @Override
    public List<Problem> getAllProblems() {
        return null;
    }

    @Override
    public List<Problem> getAllProblemByUser(int userId) {
        return null;
    }
}
