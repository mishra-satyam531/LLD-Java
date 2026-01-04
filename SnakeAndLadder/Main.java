package SnakeAndLadder;

import java.util.ArrayDeque;
import java.util.Deque;

import SnakeAndLadder.models.Dice;
import SnakeAndLadder.models.Player;

public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice(1);

        Player player1 = new Player("Satyam");
        Player player2 = new Player("Shrayansh");
        
        Deque<Player> players = new ArrayDeque<>();
        players.addLast(player1);
        players.addLast(player2);
        
        Game game = new Game(players, dice, 10, 5, 5);
        game.startGame();
    }
}
