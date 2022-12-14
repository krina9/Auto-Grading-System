package com.example.AutoGrad.dataLayer.mock;

import com.example.AutoGrad.Model.Solutions;
import java.util.List;

public interface ISolutionDAO {
    public Solutions addSolution(Solutions solution);
    public List<Solutions> getSolutionsByUserId(int userId);
    public List<Solutions> getSolutionsByUserIdAndProblemId(int userId, int problemId);
    public List<Solutions> getAllSolutions();
}
