package com.kodilla.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerLogic {

    private Random rand = new Random();

    public Move getMove(Board board, char computerSymbol) {
        List<Move> moves = new ArrayList<>();

        char[][] b = board.getBoard();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (b[row][col] == ' ') {
                    moves.add(new Move(row, col));
                }
            }
        }

        if (moves.isEmpty()) {
            return null;
        }

        return moves.get(rand.nextInt(moves.size()));
    }

}
