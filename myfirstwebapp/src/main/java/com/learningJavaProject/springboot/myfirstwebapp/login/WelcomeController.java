package com.learningJavaProject.springboot.myfirstwebapp.login;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model){
        model.put("name" , getLoggedinUsername());
        return "welcome";
    }
    
    private String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}







/*    private AuthenticationService authenticator;

    public LoginController(AuthenticationService authenticator) {
        this.authenticator = authenticator;
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "login" , method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, String password ,ModelMap model){
        model.put("name",name);
        model.put("password" , password);
        if(authenticator.authenticate(name,password)) return "welcome";

        model.put("errorMessage" , "Please ReTry wrong password entered");
        return "login";
    }*/

/*    public String gotoLoginPage(@RequestParam String name, ModelMap model){
        model.put("name" , name);
        return "login";


        logger.debug("name : {} ", name); good practice
        System.out.println(name); //Not recommended sout for production code
    }*/

