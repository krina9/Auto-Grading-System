package com.example.AutoGrad.Controllers;

import com.example.AutoGrad.Model.Problem;
import com.example.AutoGrad.dataLayer.IProblem;
import com.example.AutoGrad.dataLayer.dao.ProblemDAO;
import com.example.AutoGrad.dataLayer.mock.IProblemDAO;
import com.example.AutoGrad.factory.AutoGradFactoryCreate;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class ProblemController {
    AutoGradFactoryCreate factory = new AutoGradFactoryCreate();
    private ProblemDAO problemDAO = new ProblemDAO();
    @Lazy
    private IProblem problemService = new Problem((IProblemDAO) problemDAO);

    @GetMapping("/api/user/{userId}/problem/list")
    public ResponseEntity getAllProblemsByUser(@PathVariable("userId") int userId) {
        return ResponseEntity.ok().body(problemService.getAllProblemByUser(userId));
    }

    @PostMapping("/api/user/problem/add")
    public ResponseEntity addProblem(@ModelAttribute Problem problem) {
        return ResponseEntity.ok().body(problemService.addProblem(problem));
    }

    @GetMapping("/api/problem/{problemId}")
    public ResponseEntity getProblemById(@PathVariable("problemId") int problemId) {
        return ResponseEntity.ok().body(problemService.getProblemById(problemId));
    }

    @GetMapping("/api/problem/list")
    public ResponseEntity getAllProblems() {
        return ResponseEntity.ok().body(problemService.getAllProblems(1));
    }
}
