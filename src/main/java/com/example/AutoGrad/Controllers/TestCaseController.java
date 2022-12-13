package com.example.AutoGrad.Controllers;

import com.example.AutoGrad.Model.TestCases;
import com.example.AutoGrad.dataLayer.ITestCases;
import com.example.AutoGrad.dataLayer.dao.TestCaseDAO;
import com.example.AutoGrad.factory.AutoGradFactoryCreate;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TestCaseController {
    AutoGradFactoryCreate factory = new AutoGradFactoryCreate();
    ITestCases testCaseService = new TestCases(factory.getTestCaseFactory().create());
    @Lazy
    TestCaseDAO testCaseDAO = new TestCaseDAO();
    @Lazy
   // private ITestCases testCaseService = new TestCases(testCaseDAO);

    @PostMapping("/api/user/problem/test-case/add")
    public ResponseEntity addTestCases(@RequestBody List<TestCases> testCases) {
        List<TestCases> resultFromDB = testCaseService.addTestCases(testCases);
        if (resultFromDB != null) {
            return ResponseEntity.ok().body(testCases);
        } else{
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/api/user/problem/{problemId}/test-cases")
    public ResponseEntity getAllTestCasesByProblemId(@PathVariable int problemId) {
        return ResponseEntity.ok().body(testCaseService.getAllTestCasesByProblemId(problemId));
    }
}
