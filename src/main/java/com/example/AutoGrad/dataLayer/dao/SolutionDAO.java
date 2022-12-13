package com.example.AutoGrad.dataLayer.dao;

import com.example.AutoGrad.Model.Solutions;
import org.springframework.context.annotation.Lazy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SolutionDAO {

    @Lazy
    private Connection connection = com.example.AutoGrad.Services.Connection.getInstance();

    public Solutions addSolution(Solutions solution) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL addSolution(?,?,?,?,?,?,?)}");
            statement.setInt(1, solution.getTestCasesPassed());
            statement.setInt(2, solution.getTestCasesFailed());
            statement.setDouble(3, solution.getScore());
            statement.setDate(4, new java.sql.Date(System.currentTimeMillis()));
            statement.setBlob(5, solution.getSolution());
            statement.setInt(6, solution.getProblemId());
            statement.setInt(7, solution.getUserId());

            statement.executeQuery();
            return solution;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Solutions> getAllSolutions() {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getAllSolution()}");
            ResultSet resultSet = statement.executeQuery();
            return makeSolutionListFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Solutions> getSolutionsByUserId(int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getAllSolutionByUser(?)}");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            return makeSolutionListFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Solutions> getSolutionsByUserIdAndProblemId(int userId, int problemId) {
        try{
            PreparedStatement statement = connection.prepareStatement("{CALL getSolutionByUserIdAndProblemId(?, ?)}");
            statement.setInt(1, userId);
            statement.setInt(2, problemId);
            ResultSet resultSet = statement.executeQuery();
            return makeSolutionListFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Solutions> makeSolutionListFromResultSet(ResultSet resultSet) throws Exception {
        List<Solutions> solutions = new ArrayList<>();
        Solutions solution;
        while (resultSet.next()) {
            solution = new Solutions();
            solution.setSolutionId(resultSet.getInt("solution_id"));
            solution.setTestCasesPassed(resultSet.getInt("test_cases_passed"));
            solution.setTestCasesFailed(resultSet.getInt("test_cases_failed"));
            solution.setScore(resultSet.getDouble("score"));
            solution.setSolutionSubmittedOn(resultSet.getDate("solution_submitted_on"));
            solution.setProblemId(resultSet.getInt("problem_id"));
            solution.setUserId(resultSet.getInt("user_id"));
            solutions.add(solution);
        }
        return solutions;
    }
}
