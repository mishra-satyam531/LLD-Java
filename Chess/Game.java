package Chess;

import java.util.ArrayList;
import java.util.List;

import Chess.models.Board;
import Chess.models.GameStatus;
import Chess.models.Move;
import Chess.models.Player;

public class Game {
    private Player[] players;
    private Board board;
    private Player currentTurn;
    private GameStatus status;
    private List<Move> movesPlayed;

    public Game(Player player1, Player player2) {
        players = new Player[2];
        players[0] = player1;
        players[1] = player2;

        board = new Board();

        movesPlayed = new ArrayList<>();
        status = GameStatus.ACTIVE;

        if(player1.whiteSide) {
            currentTurn = player1;
        } else {
            currentTurn = player2;
        }
    }

    public boolean isGameEnd() {
        return this.status != GameStatus.ACTIVE;
    }
}
