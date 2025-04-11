package com.kodilla.tictactoe;

public class TicTacToeRunner {

    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe!");
        GameLogic gameLogic = new GameLogic();
        gameLogic.play();
    }
}
