package com.kodilla.tictactoe;

public class GameLogic {

    public Board board;
    private char currPlayer;
    private int numToWin;

    public GameLogic(int boardSize, int numToWin) {
        this.board = new Board(boardSize);
        this.numToWin = numToWin;
        this.currPlayer = 'X';
    }

    public void play() {
        boolean gameOver = false;

        while (!gameOver) {
            board.printBoard();
            System.out.println("Player: " + currPlayer);

            Move move = UserDialogs.getUserMove(currPlayer, board.getSize());

            boolean validMove = board.insertMove(move.getRow(), move.getCol(), currPlayer);

            if (!validMove) {
                System.out.println("Invalid move, try again");
                continue;
            }

            if(checkWinner(move.getRow(), move.getCol(), currPlayer)) {
                board.printBoard();
                System.out.println("Winner: " + currPlayer);
                gameOver = true;
            } else if (isBoardFull()) {
                board.printBoard();
                System.out.println("There is no winner, it's a tie");
                gameOver = true;
            } else {
                changePlayer();
            }
        }
    }

    private void changePlayer() {
        currPlayer = (currPlayer == 'X') ? 'O' : 'X';
    }

    private boolean checkWinner(int row, int col, char player) {
        return checkDirection(row, col, player, 1, 0)
                || checkDirection(row, col, player, 0, 1)
                || checkDirection(row, col, player, 1, 1)
                || checkDirection(row, col, player, 1, -1);
    }

    private boolean isBoardFull() {
        char[][] b = board.getBoard();

        for (char[] row : b) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }

    private boolean checkDirection(int row, int col, char player, int dr, int dc) {
        int ctr = 1;

        ctr += ctrInDirection(row, col, player, dr, dc);
        ctr += ctrInDirection(row, col, player, -dr, -dc);

        return ctr >= numToWin;
    }

    private int ctrInDirection(int row, int col, char player, int dr, int dc) {
        int size = board.getSize();
        int ctr = 0;
        int r = row + dr;
        int c = col + dc;

        while (r >= 0 && c >= 0 && r < size && c < size && board.getBoard()[r][c] == player) {
            ctr++;
            r += dr;
            c += dc;
        }

        return ctr;
    }
}
