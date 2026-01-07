package SnakeAndLadder;

import java.util.Deque;

import SnakeAndLadder.models.Board;
import SnakeAndLadder.models.Cell;
import SnakeAndLadder.models.Dice;
import SnakeAndLadder.models.Player;

public class Game {
    private Board gameBoard;
    private Deque<Player> players;
    private Dice dice;

    public Game(Deque<Player> players, Dice dice, int boardSize, int snakes, int ladders) {
        this.players = players;
        this.dice = dice;

        this.gameBoard = new Board(boardSize, snakes, ladders);
    }

    public void startGame() {
        int size = gameBoard.getSize() * gameBoard.getSize();
        boolean isWinner = false;

        System.out.println("Game Started!");

        while (!isWinner) {
            Player playerTurn = players.removeFirst();

            int outcome = dice.rollDice();
            int currentPosition = playerTurn.getCurrentPosition();
            int newPosition = currentPosition + outcome;

            if(newPosition >= size - 1) {
                System.out.println(playerTurn.getName() + " rolled " + outcome + " and moved to " + (newPosition + 1));
                System.out.println("WINNER IS: " + playerTurn.getName());
                isWinner = true;
                return;
            }

            String turnLog = playerTurn.getName() + " rolled " + outcome + ": " + (currentPosition+1) + " -> " + (newPosition+1);
            
            Cell cell = gameBoard.getCell(newPosition);
            if(cell.getJump() != null) {
                if(cell.getJump().getStart() < cell.getJump().getEnd()) {
                     System.out.println(turnLog + " (LADDER!)");
                } else {
                     System.out.println(turnLog + " (SNAKE!)");
                }
                newPosition = cell.getJump().getEnd();
            } else {
                System.out.println(turnLog);
            }

            playerTurn.setCurrentPosition(newPosition);
            players.addLast(playerTurn);
        }
    }
}
