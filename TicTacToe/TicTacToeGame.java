package TicTacToe;

import java.util.Deque;
import java.util.Scanner;

import TicTacToe.models.Board;
import TicTacToe.models.Player;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public TicTacToeGame(Deque<Player> players, Board gameBoard) {
        this.players = players;
        this.gameBoard = gameBoard;
    }

    public void startGame() {
        boolean noWinner = true;
        Scanner sc = new Scanner(System.in);

        while (noWinner) {
            Player playerTurn = players.removeFirst();

            System.out.println("Turn of player " + playerTurn.getName());

            int row = -1;
            int col = -1;
            boolean moveSuccess = false;

            while(!moveSuccess) {
                row = sc.nextInt();
                col = sc.nextInt();

                moveSuccess = gameBoard.addPiece(row, col, playerTurn.getPiece());

                if(!moveSuccess) {
                    System.out.println("Invalid move! Try again: ");
                }
            }

            gameBoard.printBoard();
            
            if(gameBoard.checkWinner(row, col, playerTurn.getPiece())) {
                System.out.println("WINNER: " + playerTurn.getName());
                break;
            }

            if(gameBoard.getFreeCells() == 0) {
                System.out.println("Game Draw!");
                break;
            }

            players.addLast(playerTurn);
        }
    }
}
