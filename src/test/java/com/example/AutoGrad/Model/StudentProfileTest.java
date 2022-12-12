package com.example.AutoGrad.Model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentProfileTest {

    @Test
    public void studentProfileObjectTest()
    {
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setFirstName("Robert");

        assertEquals(studentProfile.getFirstName(), "Robert");
    }

    @Test
    public void studentProfileNullObjectTest()
    {
        StudentProfile studentProfile = new StudentProfile();
        assertEquals(studentProfile.getFirstName(), null);
    }
}
