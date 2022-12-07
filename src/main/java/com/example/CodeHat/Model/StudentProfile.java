package com.example.CodeHat.Model;

import com.example.CodeHat.Services.dto.StudentProfileDTO;

import java.util.List;

public class StudentProfile {

    private int score;
    private int numberOfProblemSolved;
    private List<String> coreSkills;

    public StudentProfile(StudentProfileDTO studentProfileDTO) {
        this.score = studentProfileDTO.getScore();
        this.numberOfProblemSolved = studentProfileDTO.getNumberOfProblemSolved();
        this.coreSkills = studentProfileDTO.getCoreSkills();
    }

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
