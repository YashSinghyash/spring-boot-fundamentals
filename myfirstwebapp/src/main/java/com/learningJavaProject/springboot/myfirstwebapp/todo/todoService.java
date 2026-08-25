package com.learningJavaProject.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class todoService {
    private static List<todo> todos = new ArrayList<>();
    static {
        todos.add(new todo(1, "Yash Pratap Singh" , "Learn SpringBoot" , LocalDate.now().plusDays(2) , false));
        todos.add(new todo(2, "Yash Pratap Singh" , "Learn AI ML" , LocalDate.now().plusWeeks(1) , false));
        todos.add(new todo(3, "Yash Pratap Singh" , "Learn SQL" , LocalDate.now().plusWeeks(2) , false));
    }

    public List<todo> findByUserName(String username){
        return todos;
    }
}
