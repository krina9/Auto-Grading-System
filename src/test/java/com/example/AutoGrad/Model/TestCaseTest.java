package com.example.AutoGrad.Model;
import com.example.AutoGrad.dataLayer.ITestCases;
import com.example.AutoGrad.factory.AutoGradFactoryCreate;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestCaseTest{
    private AutoGradFactoryCreate factory = new AutoGradFactoryCreate();
    private ITestCases testCasesServices = new TestCases(factory.getTestCaseDAOMockFactory().create());
    @Test
    public void addTestCaseTest(){
       TestCases testCase1 = new TestCases();
       testCase1.setInput("1 2");
       testCase1.setOutput("3");
       TestCases testCase2 = new TestCases();
       testCase2.setInput("3 4");
       testCase2.setOutput("7");
       List<TestCases> testCases = new ArrayList<>();
       testCases.add(testCase1);
       testCases.add(testCase2);
       List<TestCases> testCasesFromDB = testCasesServices.addTestCases(testCases);
       assertEquals(testCasesFromDB.get(0), testCase1);
       assertEquals(testCasesFromDB.get(1), testCase2);
    }

    @Test
    public void getAllTestCasesByProblemIdTest(){
        List<TestCases> testList = testCasesServices.getAllTestCasesByProblemId(2);
        assertEquals(testList.size(), 2);
        assertEquals(testList.get(0).getInput(),"4 2");
        assertEquals(testList.get(0).getOutput(),"6");
        assertEquals(testList.get(0).getProblemId(),2);

        assertEquals(testList.get(1).getInput(),"3 5");
        assertEquals(testList.get(1).getOutput(),"8");
        assertEquals(testList.get(1).getProblemId(),2);
    }

    @Test
    public void getterSetterTest(){
        TestCases testCases=new TestCases();
        testCases.setId(1);
        testCases.setInput("1 1");
        testCases.setOutput("2");
        testCases.setProblemId(1);
        assertEquals(testCases.getId(),1);
        assertEquals(testCases.getInput(),"1 1");
        assertEquals(testCases.getOutput(),"2");
        assertEquals(testCases.getProblemId(),1);
    }
}
