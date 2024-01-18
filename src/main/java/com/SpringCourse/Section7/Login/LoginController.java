package com.SpringCourse.Section7.Login;

import com.SpringCourse.Section7.AuthenticationService.LoginAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
    private LoginAuthenticationService loginAuthenticationService;
    public LoginController(LoginAuthenticationService loginAuthenticationService) {
        this.loginAuthenticationService = loginAuthenticationService;
    }

    @RequestMapping(value="login",method = RequestMethod.GET)
    public String generateLoginPage(){
        return "login";
    }

    @RequestMapping(value="login",method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap){
        if(loginAuthenticationService.authenticate(name,password)){
            modelMap.put("name",name);

            return "redirect:recipes";
        }
        modelMap.put("ErrorMsg","Invalid Credentials");
        return "login";

    }

}
