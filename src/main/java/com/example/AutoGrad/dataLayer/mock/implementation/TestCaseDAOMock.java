package com.example.AutoGrad.dataLayer.mock.implementation;

import com.example.AutoGrad.Model.TestCases;
import com.example.AutoGrad.dataLayer.mock.ITestCaseDAO;
import java.util.ArrayList;
import java.util.List;
public class TestCaseDAOMock implements ITestCaseDAO {
    @Override
    public List<TestCases> addTestCases(List<TestCases> testCases) {
       List<TestCases> testCasesList = new ArrayList<>();
       TestCases test1 = new TestCases("2 2","4",1);
       TestCases test2=new TestCases("3 4","7",1);
       testCasesList.add(test1);
       testCasesList.add(test2);
       return testCasesList;
    }
    @Override
    public List<TestCases> getAllTestCasesByProblemId(int problemId) {
        List<TestCases> testCasesList1 = new ArrayList<>();
        TestCases test01 = new TestCases("4 2","6",2);
        TestCases test02=new TestCases("3 5","8",2);
        testCasesList1.add(test01);
        testCasesList1.add(test02);
        return testCasesList1;
    }
}
