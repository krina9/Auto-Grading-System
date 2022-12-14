package com.example.AutoGrad.Model;

import com.example.AutoGrad.dataLayer.IProblem;
import com.example.AutoGrad.dataLayer.dao.ProblemDAO;
import com.example.AutoGrad.dataLayer.mock.IProblemDAO;

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
    private IProblemDAO problemDAO;

//    public Problem(IProblemDAO problemDAO){
//        this.problemDAO=problemDAO;
//    }


    public Problem(IProblemDAO problemDAO) {
        this.problemDAO = problemDAO;
    }

    public Problem() {
    }

    public Problem(Integer id, String title, String statement, Float score, Integer numOfTestCases, String difficulty, String category, Integer userId) {
        this.id = id;
        this.title = title;
        this.statement = statement;
        this.score = score;
        this.numOfTestCases = numOfTestCases;
        this.difficulty = difficulty;
        this.category = category;
        this.userId = userId;
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

    public IProblemDAO getProblemDAO() {
        return problemDAO;
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
        Problem problemInDB = problemDAO.addProblem(problem);
        return problemInDB;
    }

    @Override
    public Problem getProblemById(int problemId) {
        return problemDAO.getProblemById(problemId);
    }

    @Override
    public List<Problem> getAllProblemByUser(int userId) {
        return problemDAO.getAllProblemByUser(userId);
    }

    @Override
    public List<Problem> getAllProblems(int bugFix) {
        return problemDAO.getAllProblems();
    }
}
