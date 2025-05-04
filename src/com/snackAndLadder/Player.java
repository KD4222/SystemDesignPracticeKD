package com.snackAndLadder;

public class Player {
    private int position;
    private String name;

    public Player(String playerName) {
        this.name=playerName;
        this.position=0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }
}
