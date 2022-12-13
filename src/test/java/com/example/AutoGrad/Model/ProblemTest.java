package com.example.AutoGrad.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemTest
{
    Problem prob = new Problem();
    @Test
    public void addProblemTest()
    {
//        statement.setString(1, problem.getTitle());
//        statement.setString(2, problem.getStatement());
//        statement.setFloat(3, problem.getScore());
//        statement.setInt(4, problem.getNumOfTestCases());
//        statement.setString(5, problem.getDifficulty());
//        statement.setString(6, problem.getCategory());
//        statement.setInt(7, problem.getUserId());
        prob.setTitle("addition");
        prob.setStatement("add 2 number");
        prob.setScore(2F);
        prob.setNumOfTestCases(2);
        prob.setDifficulty("easy");
        prob.setCategory("numerical");
        prob.setUserId(1);
        assertEquals(prob.getTitle(),"addition");
        assertEquals(prob.getStatement(),"add 2 number");
        assertEquals(prob.getScore(),2F);
        assertEquals(prob.getNumOfTestCases(),2);
        assertEquals(prob.getDifficulty(),"easy");
        assertEquals(prob.getCategory(),"numerical");
        assertEquals(prob.getUserId(),1);

    }
}
