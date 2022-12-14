package com.example.AutoGrad.dataLayer.mock.implementation;

import com.example.AutoGrad.Model.Problem;
import com.example.AutoGrad.Model.Solutions;
import com.example.AutoGrad.Model.TestCases;
import com.example.AutoGrad.dataLayer.mock.ISolutionDAO;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SolutionDAOMock implements ISolutionDAO {
    @Override
    public Solutions addSolution(Solutions solutions) {
        Solutions solutions1 = null;
        try {
            solutions1 = new Solutions(1, 2, 0, 3, new Date("2022-12-13"), new SerialBlob(new String("Test").getBytes(StandardCharsets.UTF_8)), 1, 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return solutions1;
    }
    @Override
    public List<Solutions> getSolutionsByUserId(int userId) {
        List<Solutions> solnListUser = new ArrayList<>();
        // Solutions sol1;
        //Solutions sol2;
        //Solutions sol1;
        try {

            String date = "21-9-2017";
            SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-YYYY");
            Date result = sdt.parse(date);
            Solutions sol1 = new Solutions(1, 3, 0, 4, result, new SerialBlob(new String("Test1").getBytes(StandardCharsets.UTF_8)), 1, 1);
            Solutions sol2 = new Solutions(2, 2, 0, 5, result, new SerialBlob(new String("Test2").getBytes(StandardCharsets.UTF_8)), 2, 1);
            solnListUser.add(sol1);
            solnListUser.add(sol2);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        solnListUser.add(sol1);
//        solnListUser.add(sol2);
        return solnListUser;
    }
    @Override
    public List<Solutions> getSolutionsByUserIdAndProblemId(int userId, int problemId) {
        List<Solutions> solnList = new ArrayList<>();
        try{
            String date = "21-9-2017";
            SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-YYYY");
            Date result = sdt.parse(date);

            Solutions soln1 = new Solutions(1, 4, 0, 5, result, new SerialBlob(new String("Test1").getBytes(StandardCharsets.UTF_8)), 1, 2);
            Solutions soln2 = new Solutions(2, 5, 0, 7, result, new SerialBlob(new String("Test2").getBytes(StandardCharsets.UTF_8)), 1, 2);
            solnList.add(soln1);
            solnList.add(soln2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return solnList;
    }

    @Override
    public List<Solutions> getAllSolutions() {
        return null;
    }
}
