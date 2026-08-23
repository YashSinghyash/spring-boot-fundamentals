package com.learningjava.spring.learn_spring_framework.enterprise.example.web;
import com.learningjava.spring.learn_spring_framework.enterprise.example.business.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MyWebController {
    @Autowired
    private BusinessService businessService;
    public long returnValueFromBusinessService(){
        return businessService.calculateSum();
    }
}



