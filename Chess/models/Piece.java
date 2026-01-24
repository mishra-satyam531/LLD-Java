package Chess.models;

public abstract class Piece {
    private Color color;
    private boolean isKilled;
    public Piece(Color color) {
        this.color = color;
        this.isKilled = false;
    }

    public void setIsKilled(boolean isKilled) {
        this.isKilled = isKilled;
    }

    public abstract boolean canMove(Board board, Cell start, Cell end) throws Exception;

    public Color getColor() {
        return color;
    }

    public boolean isKilled() {
        return isKilled;
    }
    
    protected boolean pathIsClear(Board board, Cell start, Cell end) {
        int xStep = Integer.compare(end.getCol(), start.getCol());
        int yStep = Integer.compare(end.getRow(), start.getRow());

        int col = start.getCol() + xStep;
        int row = start.getRow() + yStep;

        while (col != end.getCol() || row != end.getRow()) {
            try {
                if (board.getCell(row, col).getPiece() != null) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
            
            col += xStep;
            row += yStep;
        }
        return true;
    }

}
