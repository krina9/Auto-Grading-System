package com.example.AutoGrad.Model;

import com.example.AutoGrad.dataLayer.ISolutions;
import com.example.AutoGrad.factory.AutoGradFactoryCreate;
import org.junit.jupiter.api.Test;

import javax.sql.rowset.serial.SerialBlob;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private AutoGradFactoryCreate factory = new AutoGradFactoryCreate();
    private ISolutions solutionService = new Solutions(factory.getSolutionDAOMockFactory().create());
    @Test
    public void getSolutionsByUserIdTest() throws SQLException, ParseException {
        List<Solutions> solnList = solutionService.getSolutionsByUserId(1);
        assertEquals(solnList.size(), 2);
        assertEquals(solnList.get(0).getSolutionId(),1);
        assertEquals(solnList.get(0).getTestCasesPassed(),3);
        assertEquals(solnList.get(0).getTestCasesFailed(),0);
        assertEquals(solnList.get(0).getScore(),4);

        String date = "21-9-2017";
        SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-YYYY");
        Date result = sdt.parse(date);

        assertEquals(solnList.get(0).getSolutionSubmittedOn(),result);
        assertEquals(solnList.get(0).getSolution(),new SerialBlob(new String("Test1").getBytes(StandardCharsets.UTF_8)));
        assertEquals(solnList.get(0).getProblemId(),1);
        assertEquals(solnList.get(0).getUserId(),1);

        assertEquals(solnList.get(1).getSolutionId(),2);
        assertEquals(solnList.get(1).getTestCasesPassed(),2);
        assertEquals(solnList.get(1).getTestCasesFailed(),0);
        assertEquals(solnList.get(1).getScore(),5);
        assertEquals(solnList.get(1).getSolutionSubmittedOn(),result);
        assertEquals(solnList.get(1).getSolution(),new SerialBlob(new String("Test2").getBytes(StandardCharsets.UTF_8)));
        assertEquals(solnList.get(1).getProblemId(),2);
        assertEquals(solnList.get(1).getUserId(),1);

        System.out.println("Get Solution By User Id test case passed");
    }
    @Test
    public void getSolutionsByUserIdAndProblemIdTest() throws SQLException, ParseException {

        List<Solutions> solnList1 = solutionService.getSolutionsByUserIdAndProblemId(2,2);
        assertEquals(solnList1.size(), 2);
        assertEquals(solnList1.get(0).getSolutionId(),1);
        assertEquals(solnList1.get(0).getTestCasesPassed(),4);
        assertEquals(solnList1.get(0).getTestCasesFailed(),0);
        assertEquals(solnList1.get(0).getScore(),5);

        String date = "21-9-2017";
        SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-YYYY");
        Date result = sdt.parse(date);

        assertEquals(solnList1.get(0).getSolutionSubmittedOn(),result);
        assertEquals(solnList1.get(0).getSolution(),new SerialBlob(new String("Test1").getBytes(StandardCharsets.UTF_8)));
        assertEquals(solnList1.get(0).getProblemId(),1);
        assertEquals(solnList1.get(0).getUserId(),2);

        assertEquals(solnList1.get(1).getSolutionId(),2);
        assertEquals(solnList1.get(1).getTestCasesPassed(),5);
        assertEquals(solnList1.get(1).getTestCasesFailed(),0);
        assertEquals(solnList1.get(1).getScore(),7.0);
        assertEquals(solnList1.get(1).getSolutionSubmittedOn(),result);
        assertEquals(solnList1.get(1).getSolution(),new SerialBlob(new String("Test2").getBytes(StandardCharsets.UTF_8)));
        assertEquals(solnList1.get(1).getProblemId(),1);
        assertEquals(solnList1.get(1).getUserId(),2);
        System.out.println("Get Solution By User Id and problem Id test case passed");
    }

    @Test
    public void getAllSolutions() throws SQLException, ParseException {
        List<Solutions> allSolnList = solutionService.getSolutionsByUserIdAndProblemId(2,2);
        assertEquals(allSolnList.size(), 2);
        assertEquals(allSolnList.get(0).getSolutionId(),1);
        assertEquals(allSolnList.get(0).getTestCasesPassed(),5);
        assertEquals(allSolnList.get(0).getTestCasesFailed(),0);
        assertEquals(allSolnList.get(0).getScore(),15);

        String date = "21-8-2018";
        SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-YYYY");
        Date result = sdt.parse(date);

        assertEquals(allSolnList.get(0).getSolutionSubmittedOn(),result);
        assertEquals(allSolnList.get(0).getSolution(),new SerialBlob(new String("Test01").getBytes(StandardCharsets.UTF_8)));
        assertEquals(allSolnList.get(0).getProblemId(),1);
        assertEquals(allSolnList.get(0).getUserId(),3);

        assertEquals(allSolnList.get(1).getSolutionId(),2);
        assertEquals(allSolnList.get(1).getTestCasesPassed(),6);
        assertEquals(allSolnList.get(1).getTestCasesFailed(),0);
        assertEquals(allSolnList.get(1).getScore(),10);
        assertEquals(allSolnList.get(1).getSolutionSubmittedOn(),result);
        assertEquals(allSolnList.get(1).getSolution(),new SerialBlob(new String("Test02").getBytes(StandardCharsets.UTF_8)));
        assertEquals(allSolnList.get(1).getProblemId(),1);
        assertEquals(allSolnList.get(1).getUserId(),3);
        System.out.println("Get All Solution test case passed");
    }
    @Test
    public void getterSetterTest(){
        Solutions solutions=new Solutions();
        solutions.setSolutionId(1);
        solutions.setTestCasesPassed(2);
        solutions.setTestCasesFailed(0);
        solutions.setProblemId(1);
        solutions.setUserId(1);
        solutions.setScore(10);
        assertEquals(solutions.getSolutionId(),1);
        assertEquals(solutions.getTestCasesPassed(),2);
        assertEquals(solutions.getTestCasesFailed(),0);
        assertEquals(solutions.getProblemId(),1);
        assertEquals(solutions.getUserId(),1);
        assertEquals(solutions.getScore(),10);
    }
}
