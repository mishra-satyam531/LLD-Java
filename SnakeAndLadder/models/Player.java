package SnakeAndLadder.models;

public class Player {
    private String name;
    private int currentPosition;

    public Player(String name) {
        this.name = name;
        currentPosition = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
