package Chess.pieces;

import Chess.models.Board;
import Chess.models.Cell;
import Chess.models.Color;
import Chess.models.Piece;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) throws Exception {
        if(end.getPiece() != null && end.getPiece().getColor() == this.getColor()) {
            return false;
        }

        int horizontalDist = Math.abs(end.getCol() - start.getCol());
        int verticalDist = Math.abs(end.getRow() - start.getRow());

        if (horizontalDist != verticalDist || horizontalDist == 0) return false;

        int xStep;
        int yStep;
        if(end.getCol() > start.getCol()) {
            xStep = 1;
        } else {
            xStep = -1;
        }
        if(end.getRow() > start.getRow()) {
            yStep = 1;
        } else {
            yStep = -1;
        }

        int col = start.getCol() + xStep;
        int row = start.getRow() + yStep;
        while(col != end.getCol() && row != end.getRow()) {
            if(board.getCell(row, col).getPiece() != null) return false;
            col += xStep;
            row += yStep;
        }

        return true;
    }
    
}
