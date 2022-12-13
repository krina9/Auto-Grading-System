package com.example.AutoGrad.Model.dto;

public class StudentProfileDTO {

    private int score;
    private int numberOfProblemSolved;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumberOfProblemSolved() {
        return numberOfProblemSolved;
    }

    public void setNumberOfProblemSolved(int numberOfProblemSolved) {
        this.numberOfProblemSolved = numberOfProblemSolved;
    }
}
