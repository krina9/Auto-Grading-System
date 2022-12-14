package com.example.AutoGrad.factory.impl;

import com.example.AutoGrad.dataLayer.dao.ProblemDAO;
import com.example.AutoGrad.factory.AbstractFactoryDAO;
public class ProblemDAOFactory extends AbstractFactoryDAO {
    @Override
    public ProblemDAO create()
    {
        return new ProblemDAO();
    }
}
