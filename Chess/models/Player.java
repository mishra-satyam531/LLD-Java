package Chess.models;

public class Player {
    public boolean whiteSide;
    public boolean humanPlayer;
    public Player(boolean whiteSide, boolean humanPlayer) {
        this.whiteSide = whiteSide;
        this.humanPlayer = humanPlayer;
    }

    public boolean isWhiteSide() {
        return whiteSide;
    }
    
    public boolean isHumanPlayer() {
        return humanPlayer;
    }
    
}
