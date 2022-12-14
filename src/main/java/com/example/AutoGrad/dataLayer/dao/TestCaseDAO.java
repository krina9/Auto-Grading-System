package com.example.AutoGrad.dataLayer.dao;

import com.example.AutoGrad.Model.Solutions;
import com.example.AutoGrad.Model.TestCases;
import com.example.AutoGrad.dataLayer.mock.ISolutionDAO;
import com.example.AutoGrad.dataLayer.mock.ITestCaseDAO;
import org.springframework.context.annotation.Lazy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestCaseDAO implements ITestCaseDAO {

    @Lazy
    private Connection connection = com.example.AutoGrad.Services.Connection.getInstance();

    public List<TestCases> addTestCases(List<TestCases> testCases) {
        try {
            PreparedStatement statement;
            for (TestCases testCase : testCases) {
                statement = connection.prepareStatement("{CALL addTestCase(?,?,?)}");
                statement.setString(1, testCase.getInput());
                statement.setString(2, testCase.getOutput());
                statement.setInt(3, testCase.getProblemId());
                statement.executeQuery();
            }
            return testCases;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TestCases> getAllTestCasesByProblemId(int problemId) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getAllTestCasesByProblemId(?)}");
            statement.setInt(1, problemId);
            ResultSet resultSet = statement.executeQuery();
            return makeTestCaseListFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<TestCases> makeTestCaseListFromResultSet(ResultSet resultSet)throws Exception {
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
    }
}
