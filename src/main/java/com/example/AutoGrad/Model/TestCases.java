package com.example.AutoGrad.Model;

import com.example.AutoGrad.dataLayer.ITestCases;
import com.example.AutoGrad.dataLayer.dao.TestCaseDAO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TestCases implements ITestCases {

    private int id;

    private String input;

    private String output;

    private int problemId;

    private TestCaseDAO testCaseDAO;

    public TestCases() {
    }

    public TestCases(TestCaseDAO testCaseDAO) {
        this.testCaseDAO = testCaseDAO;
    }

    public TestCases(String input, String output, int problemId) {
        this.input = input;
        this.output = output;
        this.problemId = problemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    @Override
    public String toString() {
        return "TestCases{" +
                "id=" + id +
                ", input='" + input + '\'' +
                ", output='" + output + '\'' +
                ", problem_id=" + problemId +
                '}';
    }

    @Override
    public List<TestCases> addTestCases(List<TestCases> testCases) {
        return testCaseDAO.addTestCases(testCases);
    }

    @Override
    public List<TestCases> getAllTestCasesByProblemId(int problemId) {
        return testCaseDAO.getAllTestCasesByProblemId(problemId);
    }
}
