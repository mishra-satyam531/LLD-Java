package Chess.pieces;

import Chess.models.Board;
import Chess.models.Cell;
import Chess.models.Color;
import Chess.models.Piece;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) throws Exception {
        if(end.getPiece() != null && end.getPiece().getColor() == this.getColor()) {
            return false;
        }

        int horizontalDist = Math.abs(end.getCol() - start.getCol());
        int verticalDist = Math.abs(end.getRow() - start.getRow());

        if (horizontalDist * verticalDist != 0 || (horizontalDist == 0 && verticalDist == 0)) return false;

        int xStep = 0;
        int yStep = 0;
        int col = start.getCol();
        int row = start.getRow();
        if(horizontalDist == 0) {
            if(end.getRow() > start.getRow()) {
                yStep = 1;
            } else {
                yStep = -1;
            }
        } else {
            if(end.getCol() > start.getCol()) {
                xStep = 1;
            } else {
                xStep = -1;
            }
        }
        col += xStep;
        row += yStep;

        while(col != end.getCol() || row != end.getRow()) {
            if(board.getCell(row, col).getPiece() != null) return false;
            col += xStep;
            row += yStep;
        }

        return true;
    }
    
}
