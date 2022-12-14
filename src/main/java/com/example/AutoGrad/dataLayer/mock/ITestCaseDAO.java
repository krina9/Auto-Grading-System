package com.example.AutoGrad.dataLayer.mock;

import com.example.AutoGrad.Model.TestCases;

import java.util.List;

public interface ITestCaseDAO {
    public List<TestCases> addTestCases(List<TestCases> testCases);
    public List<TestCases> getAllTestCasesByProblemId(int problemId);
}
