package com.example.AutoGrad.Model;

import com.example.AutoGrad.Model.dto.UserDTO;
import com.example.AutoGrad.dataLayer.IUser;
import com.example.AutoGrad.factory.AutoGradFactoryCreate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class UserTest  {
    private AutoGradFactoryCreate factory = new AutoGradFactoryCreate();
    private IUser userServices = new User(factory.getUserCaseDAOMockFactory().create());
    @Test
    public void getterSetterTest(){
        User user=new User();
        user.setUserId(1);
        user.setFirstName("Anay");
        user.setLastName("Awasti");
        user.setEmail("anay@gmail.com");
        user.setPassword("123");
        user.setRole(Authority.STUDENT);
        assertEquals(user.getUserId(),1);
        assertEquals(user.getFirstName(),"Anay");
        assertEquals(user.getLastName(),"Awasti");
        assertEquals(user.getEmail(),"anay@gmail.com");
        assertEquals(user.getPassword(),"123");
        assertEquals(user.getRole(),Authority.STUDENT);
    }
    @Test
    public void getUserByEmailTest(){
        User us=userServices.getUserByEmail("krina@gmail.com");
        assertEquals(us.getUserId(),1);
        assertEquals(us.getFirstName(),"krina");
        assertEquals(us.getLastName(),"mistry");
        assertEquals(us.getEmail(),"krina@gmail.com");
        assertEquals(us.getPassword(),"k123");
        assertEquals(us.getRole(),Authority.STUDENT);
    }
    @Test
    public void getUserByIdTest(){
        User user=userServices.getUserById(2);
        assertEquals(user.getFirstName(),"ria");
        assertEquals(user.getLastName(),"mistry");
        assertEquals(user.getEmail(),"ria@gmail.com");
        assertEquals(user.getPassword(),"r123");
        assertEquals(user.getRole(),Authority.FACULTY);
    }
    @Test
    public void updateInstructor(){
        UserDTO userDTO = new UserDTO();
        User user = userServices.updateUser(userDTO);
        assertEquals(user.getUserId(),2);
        assertEquals(user.getFirstName(),"Anay");
        assertEquals(user.getLastName(),"Awasti");
        assertEquals(user.getEmail(),"ria@gmail.com");
        assertEquals(user.getPassword(),"r123");
        assertEquals(user.getRole(),Authority.FACULTY);
    }

    @Test
    public void getScoreByUserIdTest(){
        Solutions solutions = new Solutions();
        assertEquals(solutions.getScore(),10);
    }

    @Test
    public void getNoOfProblemSolvedTest() {
        assertEquals(userServices.getScoreByUserId(1), 5);
    }

}
