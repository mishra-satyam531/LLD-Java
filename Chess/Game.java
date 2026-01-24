package Chess;

import java.util.ArrayList;
import java.util.List;

import Chess.models.Board;
import Chess.models.Cell;
import Chess.models.Color;
import Chess.models.GameStatus;
import Chess.models.Move;
import Chess.models.Piece;
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

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) throws Exception{
        Cell startBox = board.getCell(startX, startY);
        Cell endBox = board.getCell(endX, endY);

        Piece sourcePiece = startBox.getPiece();

        if(sourcePiece == null) {
            return false;
        }

        if(player != currentTurn) {
            return false;
        }

        if((sourcePiece.getColor() != Color.WHITE && player.whiteSide) || (sourcePiece.getColor() != Color.BLACK && !player.whiteSide)) {
            return false;
        }

        if (!sourcePiece.canMove(board, startBox, endBox)) {
            return false;
        }

        Piece pieceKilled = endBox.getPiece();
        endBox.setPiece(sourcePiece);
        startBox.setPiece(null);

        Move move = new Move(startBox, endBox, sourcePiece, pieceKilled);
        movesPlayed.add(move);

        if(currentTurn == players[0]) {
            currentTurn = players[1];
        } else {
            currentTurn = players[0];
        }

        return true;
    }

    public void debugSetPiece(int row, int col, Piece piece) {
        try {
            this.board.getCell(row, col).setPiece(piece);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
