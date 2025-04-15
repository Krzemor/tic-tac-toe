package com.kodilla.tictactoe;

public class GameWithComputer {

    private Board board;
    private char player = 'X';
    private char computer = 'O';
    private ComputerLogic computerLogic;

    public GameWithComputer() {
        this.board = new Board();
        this.computerLogic = new ComputerLogic();
    }

    public void playComputer() {
        boolean gameOver = false;
        char currPlayer = player;

        while (!gameOver) {
            board.printBoard();
            System.out.println("Player: " + currPlayer);

            Move move;

            if (currPlayer == player) {
                move = UserDialogs.getUserMove(currPlayer);
            } else {
                move = computerLogic.getMove(board, computer);
                System.out.println("Computer chose: " + move.getRow() + "," + move.getCol());
            }

            boolean validMove = board.insertMove(move.getRow(), move.getCol(), currPlayer);

            if (!validMove) {
                if (currPlayer == player) {
                    System.out.println("Invalid move, try again");
                }
                continue;
            }

            if(checkWinner(currPlayer)) {
                board.printBoard();
                System.out.println("Winner: " + currPlayer);
                gameOver = true;
            } else if (isBoardFull()) {
                board.printBoard();
                System.out.println("There is no winner, it's a tie");
                gameOver = true;
            } else {
                currPlayer = (currPlayer == player) ? computer : player;
            }


        }
    }

    private boolean checkWinner(char player) {
        char[][] b = board.getBoard();
        for (int i = 0; i < 3; i++) {
            if ((b[i][0] == player && b[i][1] == player && b[i][2] == player) ||
                    (b[0][i] == player && b[1][i] == player && b[2][i] == player)) {
                return true;
            }
        }
        return (b[0][0] == player && b[1][1] == player && b[2][2] == player) ||
                (b[0][2] == player && b[1][1] == player && b[2][0] == player);
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

}
