package com.example.AutoGrad.Model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InstructorProfileTest {
    User us = new User();
    @Test
    public void updateInstructorTest()
    {
        us.setFirstName("Krina");
        us.setLastName("Mistry");
        us.setEmail("krina@gmail.com");
        assertEquals(us.getFirstName(), "Krina");
        assertEquals(us.getFirstName(), "Mistry");
        assertEquals(us.getFirstName(), "krina@gmail.com");
    }
    @Test
    public void instructorUpdatePasswordTest()
    {
        User us = new User();
        us.setPassword("jai123");
        assertEquals(us.getPassword(),"jai123");
    }
    @Test
    public void instructorProfileNullObjectTest()
    {
       // StudentProfile studentProfile = new StudentProfile();
        assertEquals(us.getFirstName(), null);
    }
}
