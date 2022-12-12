package com.example.AutoGrad.Model;

public class TestCases {

    private int id;

    private String input;

    private String output;

    private int problemId;

    public TestCases() {
    }

    public TestCases(String input, String output, int problemId) {
        this.input = input;
        this.output = output;
        this.problemId = problemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    @Override
    public String toString() {
        return "TestCases{" +
                "id=" + id +
                ", input='" + input + '\'' +
                ", output='" + output + '\'' +
                ", problem_id=" + problemId +
                '}';
    }
}
