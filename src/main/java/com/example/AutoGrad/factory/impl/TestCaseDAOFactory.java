package com.example.AutoGrad.factory.impl;

import com.example.AutoGrad.dataLayer.dao.TestCaseDAO;
import com.example.AutoGrad.factory.AbstractFactoryDAO;

public class TestCaseDAOFactory extends AbstractFactoryDAO {
    @Override
    public TestCaseDAO create()
    {
        return new TestCaseDAO();
    }
}
