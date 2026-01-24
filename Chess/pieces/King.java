package Chess.pieces;

import Chess.models.Board;
import Chess.models.Cell;
import Chess.models.Color;
import Chess.models.Piece;

public class King extends Piece {
    public King(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        if(end.getPiece() != null && end.getPiece().getColor() == this.getColor()) {
            return false;
        }

        int horizontalDist = Math.abs(end.getCol() - start.getCol());
        int verticalDist = Math.abs(end.getRow() - start.getRow());

        if (horizontalDist == 0 && verticalDist == 0) {
            return false;
        }

        return (horizontalDist <= 1 && verticalDist <= 1);
    }
}
