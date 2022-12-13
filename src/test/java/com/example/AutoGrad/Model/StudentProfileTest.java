package com.example.AutoGrad.Model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentProfileTest {

    @Test
    public void studentUpdateTest()
    {
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setFirstName("Robert");
        studentProfile.setLastName("Hawkey");
        studentProfile.setEmail("rhawkey@gmail.com");
        studentProfile.setScore(2);
        studentProfile.setNumberOfProblemSolved(2);
        assertEquals(studentProfile.getFirstName(), "Robert");
        assertEquals(studentProfile.getFirstName(), "Hawkey");
        assertEquals(studentProfile.getFirstName(), "rhawkey@gmail.com");
        assertEquals(studentProfile.getFirstName(), "2");
        assertEquals(studentProfile.getFirstName(), "2");
    }
    @Test
    public void studentUpdatePasswordTest()
    {
        User us = new User();
        us.setPassword("krina123");
        assertEquals(us.getPassword(),"krina123");
    }

    @Test
    public void studentProfileNullObjectTest()
    {
        StudentProfile studentProfile = new StudentProfile();
        assertEquals(studentProfile.getFirstName(), null);
    }
}
