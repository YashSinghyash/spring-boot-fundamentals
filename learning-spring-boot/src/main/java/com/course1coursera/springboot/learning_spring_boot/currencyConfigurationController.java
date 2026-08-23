package com.course1coursera.springboot.learning_spring_boot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;

@RestController
public class currencyConfigurationController {

    @Autowired
    private currencyServiceConfiguration configuration;

    @RequestMapping("/currency-configuration")
    public currencyServiceConfiguration retrieveAllCourses(){
        return configuration;
    }
}
