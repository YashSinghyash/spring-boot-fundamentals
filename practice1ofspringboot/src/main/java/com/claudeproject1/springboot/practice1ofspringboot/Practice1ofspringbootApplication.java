package com.claudeproject1.springboot.practice1ofspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Practice1ofspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Practice1ofspringbootApplication.class, args);
		LibraryService service = context.getBean(LibraryService.class);
		service.borrowBook("PadhoLikho");

	}

}
