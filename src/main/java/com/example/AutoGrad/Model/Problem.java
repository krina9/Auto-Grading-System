package com.example.AutoGrad.Model;

public class Problem {

    private String title;
    private String statement;
    private Float score;
    private Integer numOfTestCases;
    private String difficulty;
    private String category;

    private Integer userId;

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
}
