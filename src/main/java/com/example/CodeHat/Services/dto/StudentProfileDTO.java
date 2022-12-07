package com.example.CodeHat.Services.dto;

import java.util.List;

public class StudentProfileDTO {

    private int score;
    private int numberOfProblemSolved;
    private List<String> coreSkills;

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

    public List<String> getCoreSkills() {
        return coreSkills;
    }

    public void setCoreSkills(List<String> coreSkills) {
        this.coreSkills = coreSkills;
    }
}