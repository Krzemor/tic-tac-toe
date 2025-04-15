package com.kodilla.tictactoe;

import java.util.Scanner;

public class TicTacToeRunner {

    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Chose game type:");
        System.out.println("1) Player vs player 3x3");
        System.out.println("2) Player vs player 10x10");
        System.out.println("3) Player vs computer 3x3");


        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                GameLogic game = new GameLogic(3, 3);
                game.play();
            }
            case 2 -> {
                GameLogic game = new GameLogic(10, 5);
                game.play();
            }
            case 3 -> {
                GameWithComputer game = new GameWithComputer();
                game.playComputer();
            }
            default -> System.out.println("Invalid choice, try again");
        }
    }
}
