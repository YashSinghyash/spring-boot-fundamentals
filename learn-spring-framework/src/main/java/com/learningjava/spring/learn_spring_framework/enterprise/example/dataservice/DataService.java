package com.learningjava.spring.learn_spring_framework.enterprise.example.dataservice;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataService {
    public List<Integer> getData(){
        return Arrays.asList(10,20,30,50);
    }
}
