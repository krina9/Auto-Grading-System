package com.example.AutoGrad.Services.Impl;

import com.example.AutoGrad.Model.Problem;
import com.example.AutoGrad.Model.Solutions;
import com.example.AutoGrad.Model.TestCases;
import com.example.AutoGrad.Model.User;
import com.example.AutoGrad.Services.IProblemService;
import com.example.AutoGrad.Services.ISolutionService;
import com.example.AutoGrad.Services.ITestCaseService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

import java.io.*;
import java.nio.file.Files;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.AutoGrad.others.Constants.SUBMISSIONS_FOLDER;
import static com.example.AutoGrad.others.Constants.OS;

public class SolutionService implements ISolutionService {

    @Lazy
    private UserService userService = new UserService();

    @Lazy
    private IProblemService problemService = new ProblemService();

    @Lazy
    private ITestCaseService testCaseService = new TestCaseService();

    @Lazy
    private Connection connection = com.example.AutoGrad.Services.Connection.getInstance();

    @Override
    public Solutions addSolution(int userId, int problemId, MultipartFile file) throws Exception {
        try {
            User user = userService.getUserById(userId);
            boolean flag = false;
            if (user != null) {
                Problem problem = problemService.getProblemById(problemId);
                if (problem != null) {
                    List<Solutions> solutions = getSolutionsByUserIdAndProblemId(userId, problemId);
                    int maxTestCasesPassed = 0;
                    if (solutions != null) {
                        for (Solutions solution : solutions) {
                            if (solution.getTestCasesPassed() > maxTestCasesPassed) {
                                maxTestCasesPassed = solution.getTestCasesPassed();
                            }
                        }
                    }

                    if (maxTestCasesPassed == problem.getNumOfTestCases()) {
                        flag = true;
                    }

                    List<TestCases> testCases = testCaseService.getAllTestCasesByProblemId(problemId);
                    if (testCases == null)
                        throw new Exception("Test cases not found");

                    File userSolution = new File(SUBMISSIONS_FOLDER + file.getOriginalFilename());
//                    userSolution.createNewFile();
                    file.transferTo(userSolution);
                    sleep(5000);
                    Blob blob = new SerialBlob(Files.readAllBytes(userSolution.toPath()));
                    int totalTestCases = problem.getNumOfTestCases();
                    int testCasesPassed = evaluate(testCases, userSolution);

                    int testCasesFailed = totalTestCases - testCasesPassed;
                    double scorePerTestCase = ((problem.getScore()) / totalTestCases);
                    double usersPreviousScore = maxTestCasesPassed * scorePerTestCase;
                    double usersCurrentScore = testCasesPassed * scorePerTestCase;
                    double score = 0;
                    double userScore = userService.getScoreByUserId(userId);
                    if (usersCurrentScore > usersPreviousScore && !flag) {
                        score = usersCurrentScore;
                        double scoreToBeStored = userScore + (score - usersPreviousScore);
                        userService.updateScoreByUserId(scoreToBeStored, userId);
                    } else if (!flag) {
                        score = usersPreviousScore;
                        double scoreToBeStored = userScore + (score - usersPreviousScore);
                        userService.updateScoreByUserId(scoreToBeStored, userId);
                    }

                    Solutions solution = new Solutions();
                    solution.setTestCasesFailed(testCasesFailed);
                    solution.setTestCasesPassed(testCasesPassed);
                    solution.setScore(usersCurrentScore);
                    solution.setProblemId(problemId);
                    solution.setUserId(userId);
                    solution.setSolution(blob);
                    solution.setSolutionSubmittedOn(new Date(System.currentTimeMillis()));

                    PreparedStatement statement = connection.prepareStatement("{CALL addSolution(?,?,?,?,?,?,?)}");
                    statement.setInt(1, testCasesPassed);
                    statement.setInt(2, testCasesFailed);
                    statement.setDouble(3, usersCurrentScore);
                    statement.setDate(4, new Date(System.currentTimeMillis()));
                    statement.setBlob(5, blob);
                    statement.setInt(6, problemId);
                    statement.setInt(7, userId);

                    statement.executeQuery();
                    return solution;
                } else {
                    throw new Exception("Problem not found");
                }
            } else {
                throw new Exception("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int compileAndRun(String[] cmd, String output) throws Exception {
        Process process;
        int count = 0;
        try {
            process = new ProcessBuilder(cmd).start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String userOutput = "";
            String line;
            while ((line = reader.readLine()) != null) {
                userOutput += line;
            }
            reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            try {
                assertEquals(userOutput, output);
                count++;
                System.out.println("Test case passed");
            } catch (AssertionError ae) {
                System.out.println("Test case failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int evaluate(List<TestCases> testCases, File file) throws Exception {
        int count = 0;
        if (OS.contains("windows")) {
            String[] cmd = new String[3];
            cmd[0] = "cmd";
            cmd[1] = "/c";
            cmd[2] = "javac " + file.getAbsolutePath();
            Process process = new ProcessBuilder(cmd).start();
            process.waitFor();
            for (TestCases testCase : testCases) {
                String input = testCase.getInput();
                String output = testCase.getOutput();

                cmd[0] = "cmd";
                cmd[1] = "/c";
                cmd[2] = "cd " + SUBMISSIONS_FOLDER + " && java " + file.getName().split("\\.")[0] + " " + input;
                count += compileAndRun(cmd, output);
            }
        } else if (OS.contains("linux") | OS.contains("mac")) {
            String[] cmd = new String[3];
            cmd[0] = "/bin/bash";
            cmd[1] = "-c";
            cmd[2] = "javac " + file.getAbsolutePath();
            Process process = new ProcessBuilder(cmd).start();
            process.waitFor();
            for (TestCases testCase : testCases) {
                String input = testCase.getInput();
                String output = testCase.getOutput();

                cmd[0] = "/bin/bash";
                cmd[1] = "-c";
                cmd[2] = "cd " + SUBMISSIONS_FOLDER + " && java " + file.getName().split("\\.")[0] + " " + input;
                count += compileAndRun(cmd, output);
            }
        }
        file.delete();
        file = new File(SUBMISSIONS_FOLDER + file.getName().split("\\.")[0] + ".class");
        file.delete();
        return count;
    }

    @Override
    public List<Solutions> getAllSolutions() {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getAllSolution()}");
            ResultSet resultSet = statement.executeQuery();
            return makeListFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Solutions> getSolutionsByUserId(int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement("{CALL getAllSolutionByUser(?)}");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            return makeListFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Solutions> getSolutionsByUserIdAndProblemId(int userId, int problemId) {
        try{
            PreparedStatement statement = connection.prepareStatement("{CALL getSolutionByUserIdAndProblemId(?, ?)}");
            statement.setInt(1, userId);
            statement.setInt(2, problemId);
            ResultSet resultSet = statement.executeQuery();
            return makeListFromResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Solutions> makeListFromResultSet(ResultSet resultSet) {
        try {
            List<Solutions> solutions = new ArrayList<>();
            Solutions solution;
            while (resultSet.next()) {
                solution = new Solutions();
                solution.setSolutionId(resultSet.getInt("solution_id"));
                solution.setTestCasesPassed(resultSet.getInt("test_cases_passed"));
                solution.setTestCasesFailed(resultSet.getInt("test_cases_failed"));
                solution.setScore(resultSet.getDouble("score"));
                solution.setSolutionSubmittedOn(resultSet.getDate("solution_submitted_on"));
//                solution.setSolution(resultSet.getBlob("solution"));
                solution.setProblemId(resultSet.getInt("problem_id"));
                solution.setUserId(resultSet.getInt("user_id"));
                solutions.add(solution);
            }
            return solutions;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
