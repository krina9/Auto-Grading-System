package com.example.AutoGrad.factory.impl;
import com.example.AutoGrad.dataLayer.mock.implementation.TestCaseDAOMock;
import com.example.AutoGrad.factory.AbstractFactoryDAOMock;

public class TestCaseDAOMockFactory extends AbstractFactoryDAOMock {
    @Override
    public TestCaseDAOMock create() {
        return new TestCaseDAOMock();
    }
}
