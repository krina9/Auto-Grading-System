package com.example.AutoGrad.Model;

import com.example.AutoGrad.dataLayer.IProblem;
import com.example.AutoGrad.dataLayer.dao.ProblemDAO;

import java.util.List;

public class Problem implements IProblem {

    private Integer id;
    private String title;
    private String statement;
    private Float score;
    private Integer numOfTestCases;
    private String difficulty;
    private String category;
    private Integer userId;
    private ProblemDAO problemDAO;

    public Problem() {
    }

    public Problem(ProblemDAO problemDAO) {
        this.problemDAO = problemDAO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Integer getNumOfTestCases() {
        return numOfTestCases;
    }

    public void setNumOfTestCases(Integer numOfTestCases) {
        this.numOfTestCases = numOfTestCases;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }



    @Override
    public String toString() {
        return "Problem{" +
                "title='" + title + '\'' +
                ", statement='" + statement + '\'' +
                ", score=" + score +
                ", numOfTestCases=" + numOfTestCases +
                ", difficulty='" + difficulty + '\'' +
                ", category='" + category + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public Problem addProblem(Problem problem) {
        return problemDAO.addProblem(problem);
    }

    @Override
    public List<Problem> getAllProblems() {
        return problemDAO.getAllProblems();
    }

    @Override
    public Problem getProblemById(int problemId) {
        return problemDAO.getProblemById(problemId);
    }

    @Override
    public List<Problem> getAllProblemByUser(int userId) {
        return problemDAO.getAllProblemByUser(userId);
    }
}
