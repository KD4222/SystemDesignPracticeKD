package com.snackAndLadder;

import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderDemo {
    public void run(){
        GameManager gameManager=GameManager.getInstance();

        //start game1
        List<String> players1= Arrays.asList("Player1","Player2","Player3");
        gameManager.startNewGame(players1);

        //start game2
        List<String> players2= Arrays.asList("Player4","Player5","Player6");
        gameManager.startNewGame(players2);
    }
}
