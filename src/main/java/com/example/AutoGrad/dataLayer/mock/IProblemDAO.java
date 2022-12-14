package com.example.AutoGrad.dataLayer.mock;
import com.example.AutoGrad.Model.Problem;

import java.util.List;

public interface IProblemDAO {
    public Problem addProblem(Problem problem);
    public List<Problem> getAllProblems();
    public Problem getProblemById(int problemId);
    public List<Problem> getAllProblemByUser(int userId);

}
