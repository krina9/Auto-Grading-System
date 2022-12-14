package com.example.AutoGrad.dataLayer.mock;

import com.example.AutoGrad.Model.Problem;
import com.example.AutoGrad.Model.Solutions;
import com.example.AutoGrad.Model.TestCases;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface ISolutionDAO {
    public Solutions addSolution(Solutions solution);
    public List<Solutions> getSolutionsByUserId(int userId);
    public List<Solutions> getSolutionsByUserIdAndProblemId(int userId, int problemId);

    public List<Solutions> getAllSolutions();
}
