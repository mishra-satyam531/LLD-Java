package Chess.models;

public class Move {
    private Cell start;
    private Cell end;
    private Piece pieceMoved;
    private Piece pieceKilled;
    public Move(Cell start, Cell end, Piece pieceMoved, Piece pieceKilled) {
        this.start = start;
        this.end = end;
        this.pieceMoved = pieceMoved;
        this.pieceKilled = pieceKilled;
    }

    public Cell getStart() {
        return start;
    }

    public Cell getEnd() {
        return end;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public Piece getPieceKilled() {
        return pieceKilled;
    }
    
}
