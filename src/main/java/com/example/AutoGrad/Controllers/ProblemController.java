package com.example.AutoGrad.Controllers;

import com.example.AutoGrad.Model.Problem;
import com.example.AutoGrad.Services.IProblemService;
import com.example.AutoGrad.Services.Impl.ProblemService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProblemController {

    @Lazy
    private IProblemService problemService = new ProblemService();

    @GetMapping("/api/user/{userId}/problem/list")
    public List<Problem> getAllProblemsByUser(@PathVariable("userId") int userId) {
        return problemService.getAllProblemByUser(userId);
    }

    @PostMapping("/api/user/problem/add")
    public Problem addProblem(@ModelAttribute Problem problem) {
        return problemService.addProblem(problem);
    }

    @GetMapping("/api/problem/{problemId}")
    public Problem getProblemById(@PathVariable("problemId") int problemId) {
        return problemService.getProblemById(problemId);
    }

    @GetMapping("/api/problem/list")
    public List<Problem> getAllProblems() {
        return problemService.getAllProblems();
    }
}
