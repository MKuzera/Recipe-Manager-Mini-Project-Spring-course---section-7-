package com.SpringCourse.Section7.AuthenticationService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class LoginAuthenticationService {
    String name = "Mati";
    String password = "123";

    public boolean authenticate(String login, String password){
        if(this.name.equals(login) && this.password.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }

}
