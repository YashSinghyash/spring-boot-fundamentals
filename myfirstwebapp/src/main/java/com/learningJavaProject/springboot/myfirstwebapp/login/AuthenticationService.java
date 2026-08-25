package com.learningJavaProject.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username , String password){
        boolean isValidUser = username.equalsIgnoreCase("Yash");
        boolean isValidPWD = password.equals("Yash@Checking");
        return isValidUser && isValidPWD;
    }
}
