package com.example.AutoGrad.Controllers;

import com.example.AutoGrad.Model.TestCases;
import com.example.AutoGrad.Services.ITestCaseService;
import com.example.AutoGrad.Services.Impl.TestCaseService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TestCaseController {

    @Lazy
    private ITestCaseService testCaseService = new TestCaseService();

    @PostMapping("/api/user/problem/test-case/add")
    public ResponseEntity addTestCases(@RequestBody List<TestCases> testCases){
        return testCaseService.addTestCases(testCases);
    }

    @GetMapping("/api/user/problem/{problemId}/test-cases")
    public ResponseEntity getAllTestCasesByProblemId(@PathVariable int problemId) {
        return ResponseEntity.ok(testCaseService.getAllTestCasesByProblemId(problemId));
    }
}
