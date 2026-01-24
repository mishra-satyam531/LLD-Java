package Chess.models;

public class Cell {
    private Piece piece;
    private int row;
    private int col;
    public Cell(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}
