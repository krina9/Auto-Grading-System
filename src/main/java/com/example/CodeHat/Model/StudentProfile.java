package com.example.CodeHat.Model;

public class StudentProfile {
    private String firstName;
    private String lastName;
    private String email;
    private int score;
    private int numberOfProblemSolved;

    public StudentProfile(){
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

}
