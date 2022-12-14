package com.example.AutoGrad.dataLayer.dao;

import com.example.AutoGrad.Model.Problem;
import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.dataLayer.mock.IProblemDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProblemDAO implements IProblemDAO {
    private Connection connection = com.example.AutoGrad.Services.Connection.getInstance();
    private UserDAO userDAO = new UserDAO();
    public Problem addProblem(Problem problem) {
        try {
            User user = userDAO.getUserById(problem.getUserId());
            if (user == null) {
                throw new Exception("User not found");
            }

            PreparedStatement statement = connection.prepareStatement("{CALL addProblem(?,?,?,?,?,?,?)}");
            statement.setString(1, problem.getTitle());
            statement.setString(2, problem.getStatement());
            statement.setFloat(3, problem.getScore());
            statement.setInt(4, problem.getNumOfTestCases());
            statement.setString(5, problem.getDifficulty());
            statement.setString(6, problem.getCategory());
            statement.setInt(7, problem.getUserId());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                problem.setId(resultSet.getInt("last_insert_id()"));
            }
            return problem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Problem> getAllProblems() {
        try{
            PreparedStatement statement = connection.prepareStatement("{CALL getAllProblems()}");
            ResultSet resultSet = statement.executeQuery();
            return makeProblemListFromResultSet(resultSet);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Problem getProblemById(int problemId) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getProblemById(?)}");
            statement.setInt(1, problemId);
            ResultSet resultSet = statement.executeQuery();
            List<Problem> problems = makeProblemListFromResultSet(resultSet);
            if(problems.size() != 0) {
                return problems.get(0);
            }
            throw new Exception("Problem not found");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Problem> getAllProblemByUser(int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getProblemsByUserId(?)}");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            return makeProblemListFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Problem> makeProblemListFromResultSet(ResultSet resultSet) throws Exception {
        List<Problem> problems = new ArrayList<>();
        Problem problem;
        while (resultSet.next()) {
            problem = new com.example.AutoGrad.Model.Problem();
            problem.setId(resultSet.getInt("problem_id"));
            problem.setTitle(resultSet.getString("title"));
            problem.setStatement(resultSet.getString("statement"));
            problem.setScore(resultSet.getFloat("score"));
            problem.setNumOfTestCases(resultSet.getInt("num_of_test_cases"));
            problem.setDifficulty(resultSet.getString("difficulty"));
            problem.setCategory(resultSet.getString("category"));
            problem.setUserId(resultSet.getInt("user_id"));
            problems.add(problem);
        }
        return problems;
    }
}
