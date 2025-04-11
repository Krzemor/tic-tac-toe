package com.kodilla.tictactoe;

import java.util.Scanner;

public class UserDialogs {

    public static Move getUserMove(char currPlayer) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter move: (player" + currPlayer + ") row,column [0-2]: ");
            String move = input.nextLine();
            String[] moves = move.split(",");

            if (moves.length != 2) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            try {
                int row = Integer.parseInt(moves[0].trim());
                int col = Integer.parseInt(moves[1].trim());

                if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
                    return new Move(row, col);
                } else {
                    System.out.println("Invalid move. Row and column must be between 0 and 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid move. Try again.");
            }
        }

    }
}
