package com.example.AutoGrad.dataLayer.mock.implementation;

import com.example.AutoGrad.Model.Problem;
import com.example.AutoGrad.dataLayer.mock.IProblemDAO;
import java.util.ArrayList;
import java.util.List;
public class ProblemDAOMock implements IProblemDAO {
    @Override
    public Problem addProblem(Problem problem) {
        Problem problem1 = new Problem(
                1,
                "Palindrome",
                "Palindrome",
                16.0f,
                2,
                "hard",
                "numerical",
                1
        );
        return problem1;
    }
    @Override
    public List<Problem> getAllProblems() {
        List<Problem> problemList = new ArrayList<>();
        Problem prob1 = new Problem(
                1,
                "Test Problem",
                "Test Statement",
                5.0f,
                5,
                "easy",
                "numerical",
                1
        );
        Problem prob2 = new Problem(
                2,
                "Test Problem 2",
                "Test Statement 2",
                10.0f,
                2,
                "mediocre",
                "numerical",
                1
        );
        problemList.add(prob1);
        problemList.add(prob2);
        return problemList;
    }

    @Override
    public Problem getProblemById(int problemId) {
        Problem prob1 = new Problem(
                1,
                "Add",
                "Addition",
                6.0f,
                2,
                "easy",
                "numerical",
                1
        );
        return prob1;
    }

    @Override
    public List<Problem> getAllProblemByUser(int userId) {
        List<Problem> probListUser = new ArrayList<>();
        Problem prob1 = new Problem(
                1,
                "Subtract",
                "Subtraction",
                7.0f,
                3,
                "mediocre",
                "numerical",
                1
        );
        Problem prob2 = new Problem(
                1,
                "integration",
                "integration",
                17.0f,
                3,
                "hard",
                "numerical",
                1
        );
        probListUser.add(prob1);
        probListUser.add(prob2);
        return probListUser;
    }
}
