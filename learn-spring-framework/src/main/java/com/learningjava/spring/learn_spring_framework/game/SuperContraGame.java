package com.learningjava.spring.learn_spring_framework.game;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SuperContraGame implements GamingConsole{

    public void up(){
        System.out.println("SuperUP");
    }
    public void down(){
        System.out.println("SuperContra Down");
    }
    public void left(){
        System.out.println("SuperContra Left");
    }
    public void right(){
        System.out.println("SuperContra Right");
    }
}
