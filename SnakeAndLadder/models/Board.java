package SnakeAndLadder.models;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private Cell[][] board;
    private int boardSize;
    private int numOfSnakes;
    private int numOfLadders;

    public Board(int size, int numOfSnakes, int numOfLadders) {
        this.boardSize = size;
        board = new Cell[boardSize][boardSize];
        this.numOfSnakes = numOfSnakes;
        this.numOfLadders = numOfLadders;

        for(int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = new Cell();
            }
        }

        addSnakes();
        addLadders();
    }

    private void addSnakes() {
        int snakesPlaced = 0;

        while(snakesPlaced < numOfSnakes) {
            int start = ThreadLocalRandom.current().nextInt(0, boardSize * boardSize);
            int end = ThreadLocalRandom.current().nextInt(0, boardSize * boardSize);

            if(start <= end) {
                continue;
            }

            int row = start / boardSize;
            int col = start % boardSize;
            Cell cell = board[row][col];

            if(cell.getJump() == null) {
                cell.setJump(new Jump(start, end));
                snakesPlaced++;
            }
        }
    }

    private void addLadders() {
        int laddersPlaced = 0;

        while(laddersPlaced < numOfLadders) {
            int start = ThreadLocalRandom.current().nextInt(0, boardSize * boardSize);
            int end = ThreadLocalRandom.current().nextInt(0, boardSize * boardSize);

            if(start >= end) {
                continue;
            }

            int row = start / boardSize;
            int col = start % boardSize;
            Cell cell = board[row][col];

            if(cell.getJump() == null) {
                cell.setJump(new Jump(start, end));
                laddersPlaced++;
            }
        }
    }

    public Cell getCell(int position) {
        int row = position / boardSize;
        int col = position % boardSize;

        return board[row][col];
    }

    public int getSize() {
        return boardSize;
    }
}
