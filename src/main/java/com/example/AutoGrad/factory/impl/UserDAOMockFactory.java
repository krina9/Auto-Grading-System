package com.example.AutoGrad.factory.impl;

import com.example.AutoGrad.dataLayer.mock.implementation.UserDAOMock;
import com.example.AutoGrad.factory.AbstractFactoryDAOMock;

public class UserDAOMockFactory extends AbstractFactoryDAOMock {
    @Override
    public UserDAOMock create() {
        return new UserDAOMock();
    }
}
