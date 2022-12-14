package com.example.AutoGrad.factory.impl;

import com.example.AutoGrad.dataLayer.mock.implementation.SolutionDAOMock;
import com.example.AutoGrad.factory.AbstractFactoryDAOMock;
public class SolutionDAOMockFactory extends AbstractFactoryDAOMock {
    @Override
    public SolutionDAOMock create() {
        return new SolutionDAOMock();
    }
}
