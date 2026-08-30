package com.learningJavaProject.springboot.myfirstwebapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<todo ,Integer> {
    List<todo> findByUsername(String username);

}
