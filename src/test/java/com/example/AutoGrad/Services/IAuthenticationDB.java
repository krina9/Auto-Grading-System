package com.example.AutoGrad.Services;

import com.example.AutoGrad.Services.Impl.AuthenticationService;

public interface IAuthenticationDB
{
    public void saveUser(String userName, AuthenticationService authenticationService);
}
