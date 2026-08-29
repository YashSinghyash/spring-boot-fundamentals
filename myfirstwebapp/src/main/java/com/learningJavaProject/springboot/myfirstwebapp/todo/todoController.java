package com.learningJavaProject.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class todoController {

    private todoService todo;

    public todoController(todoService todo) {
        this.todo = todo;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username = getLoggedInUsername();
        List<todo> todos = todo.findByUserName(username);
        model.addAttribute("todos" , todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo" , method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username = getLoggedInUsername();
        todo todoObject = new todo(0 , username, "default description over here" ,LocalDate.now().plusWeeks(2) , false);
        model.put("todoObject" , todoObject);
        return "addTodo";
    }

    @RequestMapping(value = "add-todo" , method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid @ModelAttribute("todoObject") todo todoObject , BindingResult result){
        if (result.hasErrors()){
            return "addTodo";
        }
        String username = getLoggedInUsername();
        todoService.addTodo(username , todoObject.getDescription() , LocalDate.now().plusDays(4) , false);
        return "redirect:list-todos";
    }


    private String getLoggedInUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
