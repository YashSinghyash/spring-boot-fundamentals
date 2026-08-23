package com.learningjava.spring.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    @Autowired
    private GamingConsole game;

    public GameRunner(GamingConsole game){
        this.game = game;
    }

    public void run(){
        game.up();
        game.down();;
        game.left();
        game.right();
    }

/*    private MarioGame game;
    private SuperContraGame contragame;

    public GameRunner(MarioGame game) {
        this.game = game;
    }

    public GameRunner(SuperContraGame contraGame) {
        this.contragame = contraGame;
    }

    public void run() {
        game.up();
        game.down();
        game.left();
        game.right();
    }

    public void contraRun() {
        contragame.up();
        contragame.down();
        contragame.left();
        contragame.right();
    } */
}
