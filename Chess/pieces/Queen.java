package Chess.pieces;

import Chess.models.Board;
import Chess.models.Cell;
import Chess.models.Color;
import Chess.models.Piece;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        if (end.getPiece() != null && end.getPiece().getColor() == this.getColor()) {
            return false;
        }

        int horizontalDist = Math.abs(end.getCol() - start.getCol());
        int verticalDist = Math.abs(end.getRow() - start.getRow());

        boolean isDiagonal = (horizontalDist == verticalDist);
        boolean isStraight = (horizontalDist * verticalDist == 0 && horizontalDist + verticalDist != 0);

        if (!isDiagonal && !isStraight) {
            return false;
        }

        return pathIsClear(board, start, end);
    }
}
