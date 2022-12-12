package com.example.AutoGrad.Services;

import com.example.AutoGrad.Model.TestCases;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITestCaseService {

    ResponseEntity addTestCases(List<TestCases> testCases);

    List<TestCases> getAllTestCasesByProblemId(int problemId);
}
