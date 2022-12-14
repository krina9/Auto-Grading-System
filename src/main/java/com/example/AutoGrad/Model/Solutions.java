package com.example.AutoGrad.Model;

import com.example.AutoGrad.dataLayer.ISolutions;
import com.example.AutoGrad.dataLayer.dao.ProblemDAO;
import com.example.AutoGrad.dataLayer.dao.SolutionDAO;
import com.example.AutoGrad.dataLayer.dao.TestCaseDAO;
import com.example.AutoGrad.dataLayer.dao.UserDAO;
import com.example.AutoGrad.dataLayer.mock.ISolutionDAO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import static com.example.AutoGrad.others.Constants.OS;
import static com.example.AutoGrad.others.Constants.SUBMISSIONS_FOLDER;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

@Getter
@Setter
public class Solutions implements ISolutions {
    private int solutionId;
    private int testCasesPassed;
    private int testCasesFailed;
    private double score;
    private Date solutionSubmittedOn;
    private Blob solution;
    private int problemId;
    private int userId;

    private ISolutionDAO solutionDAO;

    private UserDAO userDAO = new UserDAO();

    private ProblemDAO problemDAO = new ProblemDAO();

    private TestCaseDAO testCaseDAO = new TestCaseDAO();

    public Solutions(Integer solutionId, Integer testCasesPassed, Integer testCasesFailed, double score, Date solutionSubmittedOn,Blob solution, Integer problemId,Integer userId)
    {
            this.solutionId = solutionId;
            this.testCasesPassed = testCasesPassed;
            this.testCasesFailed = testCasesFailed;
            this.score = score;
            this.solutionSubmittedOn = solutionSubmittedOn;
            this.solution = solution;
            this.problemId = problemId;
            this.userId = userId;
    }

    public Solutions(ISolutionDAO solutionDAO) {
        this.solutionDAO = solutionDAO;
    }

    public Solutions() {

    }

    @Override
    public String toString() {
        return "Solutions{" +
                "solutionId=" + solutionId +
                ", testCasesPassed=" + testCasesPassed +
                ", testCasesFailed=" + testCasesFailed +
                ", score=" + score +
                ", solutionSubmittedOn=" + solutionSubmittedOn +
                ", solution=" + solution +
                ", problemId=" + problemId +
                ", userId=" + userId +
                '}';
    }

    @Override
    public Solutions addSolution(int userId, int problemId, MultipartFile file) throws Exception {
        try {
            User user = userDAO.getUserById(userId);
            boolean flag = false;
            if (user != null) {
                com.example.AutoGrad.Model.Problem problem = problemDAO.getProblemById(problemId);
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

                    List<TestCases> testCases = testCaseDAO.getAllTestCasesByProblemId(problemId);
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
                    double userScore = userDAO.getScoreByUserId(userId);
                    if (usersCurrentScore > usersPreviousScore && !flag) {
                        score = usersCurrentScore;
                        double scoreToBeStored = userScore + (score - usersPreviousScore);
                        userDAO.updateScoreByUserId(scoreToBeStored, userId);
                    } else if (!flag) {
                        score = usersPreviousScore;
                        double scoreToBeStored = userScore + (score - usersPreviousScore);
                        userDAO.updateScoreByUserId(scoreToBeStored, userId);
                    }

                    Solutions solution = new Solutions();
                    solution.setTestCasesFailed(testCasesFailed);
                    solution.setTestCasesPassed(testCasesPassed);
                    solution.setScore(usersCurrentScore);
                    solution.setProblemId(problemId);
                    solution.setUserId(userId);
                    solution.setSolution(blob);
                    solution.setSolutionSubmittedOn(new java.sql.Date(System.currentTimeMillis()));

                    return solutionDAO.addSolution(solution);

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
        return solutionDAO.getAllSolutions();
    }

    @Override
    public List<Solutions> getSolutionsByUserId(int userId) {
        return solutionDAO.getSolutionsByUserId(userId);
    }

    @Override
    public List<Solutions> getSolutionsByUserIdAndProblemId(int userId, int problemId) {
        return solutionDAO.getSolutionsByUserIdAndProblemId(userId, problemId);
    }
}
