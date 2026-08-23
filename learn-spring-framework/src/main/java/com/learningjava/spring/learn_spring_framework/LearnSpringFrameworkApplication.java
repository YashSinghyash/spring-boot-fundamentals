package com.learningjava.spring.learn_spring_framework;

import com.learningjava.spring.learn_spring_framework.enterprise.example.web.MyWebController;
import com.learningjava.spring.learn_spring_framework.game.GameRunner;
import com.learningjava.spring.learn_spring_framework.game.MarioGame;
import com.learningjava.spring.learn_spring_framework.game.SuperContraGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.learningjava.spring.learn_spring_framework")
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();


		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());























/*		MarioGame mg = new MarioGame();
		GameRunner marioRunner = new GameRunner(mg);
		marioRunner.run();*/
/*		MarioGame game = new MarioGame();  //instance of MarioGame
		GameRunner runner = new GameRunner(game);  //instance of GameRunner
		runner.run(); // GameRunner function call*/
	}
}
