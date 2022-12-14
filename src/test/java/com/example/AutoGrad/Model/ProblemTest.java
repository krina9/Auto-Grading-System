package com.example.AutoGrad.Model;

import com.example.AutoGrad.dataLayer.IProblem;
import com.example.AutoGrad.dataLayer.mock.IProblemDAO;
import com.example.AutoGrad.dataLayer.mock.implementation.ProblemDAOMock;
import com.example.AutoGrad.factory.AutoGradFactoryCreate;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemTest {

    private AutoGradFactoryCreate factory = new AutoGradFactoryCreate();
    private IProblem problemService = new Problem(factory.getProblemDAOMockFactory().create());
    @Test
    public void addProblemTest()
    {
        Problem problem1 = problemService.addProblem(new Problem());
        assertEquals(problem1.getId(),1);
        assertEquals(problem1.getTitle(),"Palindrome");
        assertEquals(problem1.getStatement(),"Palindrome");
        assertEquals(problem1.getScore(),16.0f);
        assertEquals(problem1.getNumOfTestCases(),2);
        assertEquals(problem1.getDifficulty(),"hard");
        assertEquals(problem1.getCategory(),"numerical");
        assertEquals(problem1.getUserId(),1);
        System.out.println("Add problem test case passed");

    }
    @Test
    public void getAllProblemsTest(){
        List<Problem> problemList = problemService.getAllProblems(1);
        assertEquals(problemList.size(), 2);
        assertEquals(problemList.get(0).getId(), 1);
        assertEquals(problemList.get(0).getTitle(), "Test Problem");
        assertEquals(problemList.get(0).getStatement(),"Test Statement");
        assertEquals(problemList.get(0).getScore(),5.0f);
        assertEquals(problemList.get(0).getNumOfTestCases(),5);
        assertEquals(problemList.get(0).getDifficulty(),"easy");
        assertEquals(problemList.get(0).getCategory(),"numerical");
        assertEquals(problemList.get(0).getUserId(),1);

        assertEquals(problemList.get(1).getId(), 2);
        assertEquals(problemList.get(1).getTitle(), "Test Problem 2");
        assertEquals(problemList.get(1).getStatement(),"Test Statement 2");
        assertEquals(problemList.get(1).getScore(),10.0f);
        assertEquals(problemList.get(1).getNumOfTestCases(),2);
        assertEquals(problemList.get(1).getDifficulty(),"mediocre");
        assertEquals(problemList.get(1).getCategory(),"numerical");
        assertEquals(problemList.get(1).getUserId(),1);
        System.out.println("Get Problem test case passed");
    }

    @Test
    public void getProblemByIdTest(){
       Problem prob = problemService.getProblemById(1);
       assertEquals(prob.getId(),1);
       assertEquals(prob.getTitle(),"Add");
       assertEquals(prob.getStatement(),"Addition");
       assertEquals(prob.getScore(),6.0f);
       assertEquals(prob.getNumOfTestCases(),2);
       assertEquals(prob.getDifficulty(),"easy");
       assertEquals(prob.getCategory(),"numerical");
       assertEquals(prob.getUserId(),1);
       System.out.println("Get Problem By Id test case passed");

    }

    @Test
    public void getAllProblemByUserTest(){
        List<Problem> problemList = problemService.getAllProblemByUser(1);
        assertEquals(problemList.size(), 2);
        assertEquals(problemList.get(0).getId(), 1);
        assertEquals(problemList.get(0).getTitle(), "Subtract");
        assertEquals(problemList.get(0).getStatement(),"Subtraction");
        assertEquals(problemList.get(0).getScore(),7.0f);
        assertEquals(problemList.get(0).getNumOfTestCases(),3);
        assertEquals(problemList.get(0).getDifficulty(),"mediocre");
        assertEquals(problemList.get(0).getCategory(),"numerical");
        assertEquals(problemList.get(0).getUserId(),1);

        assertEquals(problemList.get(1).getId(), 1);
        assertEquals(problemList.get(1).getTitle(), "integration");
        assertEquals(problemList.get(1).getStatement(),"integration");
        assertEquals(problemList.get(1).getScore(),17.0f);
        assertEquals(problemList.get(1).getNumOfTestCases(),3);
        assertEquals(problemList.get(1).getDifficulty(),"hard");
        assertEquals(problemList.get(1).getCategory(),"numerical");
        assertEquals(problemList.get(1).getUserId(),1);
        System.out.println("Get Problem by userId test case passed");
    }
}
