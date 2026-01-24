package Chess.pieces;

import Chess.models.Board;
import Chess.models.Cell;
import Chess.models.Color;
import Chess.models.Piece;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) throws Exception {
        
        if (end.getPiece() != null && end.getPiece().getColor() == this.getColor()) {
            return false;
        }

        int direction = (this.getColor() == Color.WHITE) ? -1 : 1;
        
        int startRow = start.getRow();
        int endRow = end.getRow();
        int startCol = start.getCol();
        int endCol = end.getCol();

        // SCENARIO 1: Basic Move (1 Step Forward)
        if (startCol == endCol && endRow == startRow + direction) {
            return end.getPiece() == null;
        }

        // SCENARIO 2: First Move (2 Steps Forward)
        boolean isStartingPos = (this.getColor() == Color.WHITE && startRow == 6) ||
                                (this.getColor() == Color.BLACK && startRow == 1);

        if (isStartingPos && startCol == endCol && endRow == startRow + (2 * direction)) {
            if (end.getPiece() != null) return false;

            Cell middleCell = board.getCell(startRow + direction, startCol);
            return middleCell.getPiece() == null;
        }

        // SCENARIO 3: Capture (1 Step Diagonal)
        if (endRow == startRow + direction) {
            if (Math.abs(startCol - endCol) == 1) {
                return end.getPiece() != null;
            }
        }

        return false;
    }
    
}
