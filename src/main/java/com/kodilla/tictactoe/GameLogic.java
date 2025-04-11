package com.kodilla.tictactoe;

public class GameLogic {

    private Board board;
    private char currPlayer;

    public GameLogic() {
        board = new Board();
        currPlayer = 'X';
    }

    public void play() {
        boolean gameOver = false;

        while (!gameOver) {
            board.printBoard();
            System.out.println("Player: " + currPlayer);

            Move move = UserDialogs.getUserMove(currPlayer);

            boolean validMove = board.insertMove(move.getRow(), move.getCol(), currPlayer);

            if (!validMove) {
                System.out.println("Invalid move, try again");
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
                changePlayer();
            }
        }
    }

    private void changePlayer() {
        currPlayer = (currPlayer == 'X') ? 'O' : 'X';
    }

    private boolean checkWinner(char player) {
        char [][] b = board.getBoard();

        //Rows, columns
        for (int i = 0; i < b.length; i++) {
            if ((b[i][0] == player && b[i][1] == player && b[i][2] == player) || (b[0][i] == player && b[1][i] == player && b[2][i] == player)) {
                return true;
            }
        }

        //Diagonals
        return (b[0][0] == player && b[1][1] == player && b[2][2] == player) || (b[0][2] == player && b[1][1] == player && b[2][0] == player);
    }

    private boolean isBoardFull() {
        char[][] b = board.getBoard();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
