package com.course1coursera.springboot.learning_spring_boot;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class courseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1 , "Learn AWS" , "Yash Pratap Singh"),
                new Course(2, "Learn DevOps" , "CheckingCourse2"),
                new Course(3, "Course 3" , "Author of Course 3")
        );
    }
}
