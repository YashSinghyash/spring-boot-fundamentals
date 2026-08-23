package com.claudeproject1.springboot.practice1ofspringboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailNotifier implements Notifier{
    public void notify(String message){
        System.out.println("EMAIL..."  + message);
    }

}
