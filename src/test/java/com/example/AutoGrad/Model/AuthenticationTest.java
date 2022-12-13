package com.example.AutoGrad.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthenticationTest {
    User us = new User();
    @Test
    public void addUserTest()
    {
        us.setFirstName("Trusha");
        us.setLastName("Shah");
        us.setEmail("trusha.shah123@gmail.com");
        assertEquals(us.getFirstName(), "Trusha");
        assertEquals(us.getFirstName(), "Shah");
        assertEquals(us.getFirstName(), "trusha.shah123@gmail.com");
    }
    @Test
    public void userAddSuccessfulTest()
    {
        us.setEmail("trusha.shah123@gmail.com");
        assertEquals(us.getEmail(),"trusha.shah123@gmail.com");
    }

}
