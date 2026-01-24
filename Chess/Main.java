package Chess;

import Chess.models.Player;
import Chess.models.Color;
import Chess.pieces.Bishop;
import Chess.pieces.Knight;
import Chess.pieces.Pawn;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Starting Game Simulation ---");
        Player p1 = new Player(true, true);  // White, Human
        Player p2 = new Player(false, true); // Black, Human
        Game game = new Game(p1, p2);

        initializeTestBoard(game);

        try {
            // --------------------------------------------------------
            // MOVE 1: White Pawn moves e2 (6,4) -> e4 (4,4)
            // --------------------------------------------------------
            System.out.println("\n1. White attempts: Pawn e2 -> e4");
            boolean move1 = game.playerMove(p1, 6, 4, 4, 4);
            System.out.println("   Result: " + (move1 ? "SUCCESS" : "FAILED"));

            // --------------------------------------------------------
            // MOVE 2: Black Pawn moves e7 (1,4) -> e5 (3,4)
            // --------------------------------------------------------
            System.out.println("\n2. Black attempts: Pawn e7 -> e5");
            boolean move2 = game.playerMove(p2, 1, 4, 3, 4);
            System.out.println("   Result: " + (move2 ? "SUCCESS " : "FAILED"));

            // --------------------------------------------------------
            // MOVE 3: White Knight moves g1 (7,6) -> f3 (5,5)
            // --------------------------------------------------------
            System.out.println("\n3. White attempts: Knight g1 -> f3");
            boolean move3 = game.playerMove(p1, 7, 6, 5, 5);
            System.out.println("   Result: " + (move3 ? "SUCCESS " : "FAILED"));

            // --------------------------------------------------------
            // MOVE 4: INVALID MOVE - Black Bishop tries to jump over pawns!
            // Bishop at f8 (0,5) -> c5 (3,2). Path is blocked by d7 pawn.
            // --------------------------------------------------------
            System.out.println("\n4. Black Bishop tries to jump: f8 -> c5");
            boolean move4 = game.playerMove(p2, 0, 5, 3, 2);
            System.out.println("   Result: " + (move4 ? "SUCCESS " : "BLOCKED"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void initializeTestBoard(Game game) {
        game.debugSetPiece(6, 4, new Pawn(Color.WHITE));   // Pawn at e2
        game.debugSetPiece(7, 6, new Knight(Color.WHITE)); // Knight at g1

        game.debugSetPiece(1, 4, new Pawn(Color.BLACK));   // Pawn at e7
        game.debugSetPiece(0, 5, new Bishop(Color.BLACK)); // Bishop at f8
        
        game.debugSetPiece(2, 3, new Pawn(Color.WHITE));
    }
}
