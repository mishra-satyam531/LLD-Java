package TicTacToe;

import java.util.ArrayDeque;
import java.util.Deque;

import TicTacToe.models.Board;
import TicTacToe.models.Player;
import TicTacToe.models.PlayerPiece;
import TicTacToe.models.PlayerPieceO;
import TicTacToe.models.PlayerPieceX;

public class Main {
    public static void main(String[] args) {
        Deque<Player> players = new ArrayDeque<>();
        Board gameBoard = new Board(3);

        // player1
        PlayerPiece noughtPiece = new PlayerPieceO();
        Player player1 = new Player("Satyam", noughtPiece);
        players.addLast(player1);

        // player2
        PlayerPiece crossPiece = new PlayerPieceX();
        Player player2 = new Player("Rahul", crossPiece);
        players.addLast(player2);

        TicTacToeGame game = new TicTacToeGame(players, gameBoard);
        game.startGame();
    }
}
