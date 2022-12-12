package com.example.AutoGrad.Services;

import com.example.AutoGrad.Services.Impl.AuthenticationService;

public class AuthenticationMock implements IAuthenticationDB{
    @Override
    public void saveUser(String userName, AuthenticationService authenticationService) {
        if(userName.equals("trusha"))
        {

        }
    }
}
