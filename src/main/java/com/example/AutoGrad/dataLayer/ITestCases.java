package com.example.AutoGrad.dataLayer;

import com.example.AutoGrad.Model.TestCases;
import java.util.List;
public interface ITestCases {
    List<TestCases> addTestCases(List<TestCases> testCases);
    List<TestCases> getAllTestCasesByProblemId(int problemId);
}
