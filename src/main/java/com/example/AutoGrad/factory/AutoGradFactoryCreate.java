package com.example.AutoGrad.factory;

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
    public TestCaseDAOMockFactory getTestCaseDAOMockFactory() {
        return new TestCaseDAOMockFactory();
    }
    public UserDAOMockFactory getUserCaseDAOMockFactory(){
        return new UserDAOMockFactory();
    }
}
