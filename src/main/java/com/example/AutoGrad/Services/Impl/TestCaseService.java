package com.example.AutoGrad.Services.Impl;

import com.example.AutoGrad.Model.TestCases;
import com.example.AutoGrad.Services.ITestCaseService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestCaseService implements ITestCaseService {

    @Lazy
    private Connection connection = com.example.AutoGrad.Services.Connection.getInstance();

    @Override
    public ResponseEntity addTestCases(List<TestCases> testCases) {
        try {
            PreparedStatement statement;
            for (TestCases testCase : testCases) {
                statement = connection.prepareStatement("{CALL addTestCase(?,?,?)}");
                statement.setString(1, testCase.getInput());
                statement.setString(2, testCase.getOutput());
                statement.setInt(3, testCase.getProblemId());
                statement.executeQuery();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Override
    public List<TestCases> getAllTestCasesByProblemId(int problemId) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getAllTestCasesByProblemId(?)}");
            statement.setInt(1, problemId);
            ResultSet resultSet = statement.executeQuery();
            List<TestCases> testCases = new ArrayList<>();
            TestCases testCase;
            while (resultSet.next()) {
                testCase = new TestCases(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                );
                testCases.add(testCase);
            }
            return testCases;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
