package com.claudeproject1.springboot.practice1ofspringboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties (prefix = "library")
public class LibrarySettings {
    private String name;
    private int maxBookPerUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxBookPerUser() {
        return maxBookPerUser;
    }

    public void setMaxBookPerUser(int maxBookPerUser) {
        this.maxBookPerUser = maxBookPerUser;
    }
}
