package com.example.AutoGrad.factory.impl;

import com.example.AutoGrad.dataLayer.mock.implementation.ProblemDAOMock;
import com.example.AutoGrad.factory.AbstractFactoryDAOMock;

public class ProblemDAOMockFactory extends AbstractFactoryDAOMock {
    @Override
    public ProblemDAOMock create() {
        return new ProblemDAOMock();
    }
}
