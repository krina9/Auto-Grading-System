package com.example.AutoGrad.Controllers;

import com.example.AutoGrad.Model.Problem;
import com.example.AutoGrad.dataLayer.IProblem;
import com.example.AutoGrad.dataLayer.dao.ProblemDAO;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProblemController {

    @Lazy
    private ProblemDAO problemDAO = new ProblemDAO();
    @Lazy
    private IProblem problemService = new Problem(problemDAO);

    @GetMapping("/api/user/{userId}/problem/list")
    public List<com.example.AutoGrad.Model.Problem> getAllProblemsByUser(@PathVariable("userId") int userId) {
        return problemService.getAllProblemByUser(userId);
    }

    @PostMapping("/api/user/problem/add")
    public com.example.AutoGrad.Model.Problem addProblem(@ModelAttribute Problem problem) {
        return problemService.addProblem(problem);
    }

    @GetMapping("/api/problem/{problemId}")
    public com.example.AutoGrad.Model.Problem getProblemById(@PathVariable("problemId") int problemId) {
        return problemService.getProblemById(problemId);
    }

    @GetMapping("/api/problem/list")
    public List<com.example.AutoGrad.Model.Problem> getAllProblems() {
        return problemService.getAllProblems();
    }
}
