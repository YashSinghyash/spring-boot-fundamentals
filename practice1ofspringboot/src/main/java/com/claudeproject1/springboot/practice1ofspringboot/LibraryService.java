package com.claudeproject1.springboot.practice1ofspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryService {

    private Notifier notifier;

    @Autowired
    public LibraryService(Notifier n){
        this.notifier = n;
    }

    public void borrowBook(String bookName){
        String msg = "Borrowed: " + bookName;
        System.out.println(msg);
        notifier.notify(msg);
    }

}
