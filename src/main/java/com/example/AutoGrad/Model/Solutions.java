package com.example.AutoGrad.Model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;
import java.util.Date;

@Getter
@Setter
public class Solutions {
    private int solutionId;
    private int testCasesPassed;
    private int testCasesFailed;
    private double score;
    private Date solutionSubmittedOn;
    private Blob solution;
    private int problemId;
    private int userId;

}
