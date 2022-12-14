package com.example.AutoGrad.Model;

import com.example.AutoGrad.dataLayer.IProblem;
import com.example.AutoGrad.factory.AutoGradFactoryCreate;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemTest {

    private AutoGradFactoryCreate factory = new AutoGradFactoryCreate();
//    private IProblem problemService = new Problem(factory.getProblemDAOMockFactory().create());

    @Test
    public void getAllProblemsTest(){
//        List<Problem> problemList = problemService.getAllProblem();
//        assertEquals(problemList.size(), 2);
//        assertEquals(problemList.get(0).getId(), 1);
    }
}
