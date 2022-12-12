package com.example.CodeHat.Model;

public class Person {

    private String first_name;
    private String last_name;
    private String score;

    public Person(String first_name, String last_name, String score) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.score = score;

    }
    public Person() {

    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
        return;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }


    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }
}
