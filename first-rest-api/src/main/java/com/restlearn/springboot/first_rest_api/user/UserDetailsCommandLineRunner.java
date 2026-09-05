package com.restlearn.springboot.first_rest_api.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {

    public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
        this.repository = repository;
    }

    private Logger logger = LoggerFactory.getLogger(getClass());
    private UserDetailsRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new UserDetails("Yash" , "Admin"));
        repository.save(new UserDetails("Check_02" , "Roomy"));
        repository.save(new UserDetails("Check_03" , "debugRole"));

        List<UserDetails> users = repository.findByRole("Admin");
        users.forEach(user -> logger.info(user.toString()));

    }
}
