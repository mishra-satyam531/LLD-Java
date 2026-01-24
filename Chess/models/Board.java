package Chess.models;

public class Board {
    Cell[][] board;

    public Board() {
        board = new Cell[8][8];
        resetBoard();
    }

    private void resetBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell(i, j, null);
            }
        }
    }

    public Cell getCell(int x, int y) throws Exception {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return board[x][y];
    }

}
