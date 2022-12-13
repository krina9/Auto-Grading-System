package com.example.AutoGrad.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCaseServiceTest {
    TestCases tc = new TestCases();
    @Test
    public void addTestCaseTest()
    {
        tc.setInput("1 2 3");
        tc.setOutput("6");
        tc.setProblemId(1);
        tc.setId(1);
        assertEquals(tc.getInput(),"1 2 3");
        assertEquals(tc.getOutput(),"6");
        assertEquals(tc.getProblemId(),1);
        assertEquals(tc.getId(),1);
    }
}
