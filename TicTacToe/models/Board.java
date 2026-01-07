package TicTacToe.models;

public class Board {
    private int size;
    private PlayerPiece[][] board;
    private int freecells;

    public Board(int size) {
        this.size = size;
        this.board = new PlayerPiece[size][size];
        this.freecells = size * size;
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public boolean addPiece(int row, int col, PlayerPiece piece) {
        if (!isValid(row, col)) {
            System.out.println("Enter valid coordinates.");
            return false;
        }

        if (board[row][col] != null) {
            System.out.println("Position already filled! Try again");
            return false;
        }

        board[row][col] = piece;
        freecells--;
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(" " + board[i][j].getPieceType().name() + " ");
                } else {
                    System.out.print("   ");
                }

                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("-----------");
            }
        }
    }

    public int getSize() {
        return board.length;
    }

    public boolean checkWinner(int row, int col, PlayerPiece piece) {
        // check column
        boolean columnMatch = true;
        for(int r = 0; r < board.length; r++) {
            if(board[r][col] == null || board[r][col].getPieceType() != piece.getPieceType()) {
                columnMatch = false;
                break;
            }
        }
        if(columnMatch) return true;

        // check row
        boolean rowMatch = true;
        for(int c = 0; c < board.length; c++) {
            if(board[row][c] == null || board[row][c].getPieceType() != piece.getPieceType()) {
                rowMatch = false;
                break;
            }
        }
        if(rowMatch) return true;

        // check diagonal;
        if (row == col) {
            boolean diagonalMatch = true;
            for(int i = 0; i < size; i++) {
                if(board[i][i] == null || board[i][i].getPieceType() != piece.getPieceType()) {
                    diagonalMatch = false;
                    break;
                }
            }
            if(diagonalMatch) return true;
        }

        // check anti - diagonal
        if (row + col == size - 1) {
            boolean antiDiagonalMatch = true;
            for(int i = 0; i < size; i++) {
                if(board[i][size - i - 1] == null || board[i][size - i - 1].getPieceType() != piece.getPieceType()) {
                    antiDiagonalMatch = false;
                    break;
                }
            }
            if(antiDiagonalMatch) return true;
        }

        return false;
    }

    public int getFreeCells() {
        return freecells;
    }
}
