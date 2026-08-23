package com.claudeproject1.springboot.practice1ofspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {
    @Autowired
    private LibrarySettings settings;

    @RequestMapping("/libraryDetails")
    public LibrarySettings getSettings(){
        return settings;
    }
}
