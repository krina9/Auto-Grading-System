package com.example.AutoGrad.factory;

import com.example.AutoGrad.dataLayer.dao.ProblemDAO;
import com.example.AutoGrad.dataLayer.mock.implementation.ProblemDAOMock;
import com.example.AutoGrad.factory.impl.*;

public class AutoGradFactoryCreate {
    public ProblemDAOFactory getProblemFactory()
    {
        return new ProblemDAOFactory();
    }
    public SolutionDAOFactory getSolutionFactory()
    {
        return new SolutionDAOFactory();
    }
    public TestCaseDAOFactory getTestCaseFactory()
    {
        return new TestCaseDAOFactory();
    }

    public ProblemDAOMockFactory getProblemDAOMockFactory() {
        return new ProblemDAOMockFactory();
    }

    public SolutionDAOMockFactory getSolutionDAOMockFactory() {
        return new SolutionDAOMockFactory();
    }
}
