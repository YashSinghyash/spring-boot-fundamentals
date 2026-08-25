package com.learningJavaProject.springboot.myfirstwebapp.login;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;


@Controller
public class LoginController {


    private AuthenticationService authenticator;

    public LoginController(AuthenticationService authenticator) {
        this.authenticator = authenticator;
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "login" , method = RequestMethod.GET)
    public String goToLoginPage(){
        return "login";
    }

    @RequestMapping(value = "login" , method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, String password ,ModelMap model){
        model.put("name",name);
        model.put("password" , password);
        if(authenticator.authenticate(name,password)) return "welcome";

        model.put("errorMessage" , "Please ReTry wrong password entered");
        return "login";
    }

/*    public String gotoLoginPage(@RequestParam String name, ModelMap model){
        model.put("name" , name);
        return "login";


        logger.debug("name : {} ", name); good practice
        System.out.println(name); //Not recommended sout for production code
    }*/
}
