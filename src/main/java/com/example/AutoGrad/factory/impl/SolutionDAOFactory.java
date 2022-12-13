package com.example.AutoGrad.factory.impl;

import com.example.AutoGrad.dataLayer.dao.ProblemDAO;
import com.example.AutoGrad.dataLayer.dao.SolutionDAO;
import com.example.AutoGrad.factory.AbstractFactoryDAO;

public class SolutionDAOFactory extends AbstractFactoryDAO {
    @Override
    public SolutionDAO create()
    {
        return new SolutionDAO();
    }
}
