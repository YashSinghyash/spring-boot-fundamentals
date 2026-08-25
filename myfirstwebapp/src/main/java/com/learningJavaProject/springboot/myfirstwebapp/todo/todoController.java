package com.learningJavaProject.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class todoController {

    private todoService todo;

    public todoController(todoService todo) {
        this.todo = todo;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        List<todo> todos = todo.findByUserName("Yash Pratap Singh");
        model.addAttribute("todos" , todos);
        return "listTodos";
    }
}
