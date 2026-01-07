package TicTacToe.models;

public class PlayerPiece {
    private PieceType piece;

    public PlayerPiece(PieceType piece) {
        this.piece = piece;
    }

    public PieceType getPieceType() {
        return this.piece;
    }
}
