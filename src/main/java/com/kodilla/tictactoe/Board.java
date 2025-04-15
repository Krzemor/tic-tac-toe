package com.kodilla.tictactoe;

public class Board {

    private char[][] board;

    public Board(int size) {
        board = new char[size][size];
        for (char[] row: board) {
            java.util.Arrays.fill(row, ' ');
        }
    }

    private void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {

        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();

        }
    }

    public boolean insertMove(int row, int col, char symbol) {
        if (row >= 0 && col >= 0 && row < board.length && col < board.length && board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public char[][] getBoard() {
        return board;
    }

    public int getSize() {
        return board.length;
    }
}
