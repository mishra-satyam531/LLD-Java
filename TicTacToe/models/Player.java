package TicTacToe.models;

public class Player {
    private String name;
    private PlayerPiece piece;

    public Player(String name, PlayerPiece piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return this.name;
    }

    public PlayerPiece getPiece() {
        return this.piece;
    }
}
