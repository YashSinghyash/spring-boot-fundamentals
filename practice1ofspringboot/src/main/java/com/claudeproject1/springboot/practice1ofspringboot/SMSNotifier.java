package com.claudeproject1.springboot.practice1ofspringboot;

import org.springframework.stereotype.Component;

@Component
public class SMSNotifier implements Notifier{
    public void notify(String message){
        System.out.println("SMS ..." + message);

    }
}
