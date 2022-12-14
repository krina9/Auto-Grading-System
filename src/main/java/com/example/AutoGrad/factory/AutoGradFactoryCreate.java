package com.example.AutoGrad.factory;

import com.example.AutoGrad.factory.impl.ProblemDAOFactory;
import com.example.AutoGrad.factory.impl.ProblemDAOMockFactory;
import com.example.AutoGrad.factory.impl.SolutionDAOFactory;
import com.example.AutoGrad.factory.impl.TestCaseDAOFactory;

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
}
