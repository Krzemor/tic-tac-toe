package com.kodilla.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTestSuite {

    @Test
    public void testOWinsInRows() {
        for (int row = 0; row < 3; row++) {
            //Given
            GameLogic gameLogic = new GameLogic();

            //When
            for (int col = 0; col < 3; col++) {
                gameLogic.board.insertMove(row, col, 'O');
            }

            //Then
            assertTrue(gameLogic.checkWinner('O'), "O should be winner in row " + row);
        }

    }

    @Test
    public void testOWinsInColumns() {
        for (int col = 0; col < 3; col++) {
            //Given
            GameLogic gameLogic = new GameLogic();

            //When
            for (int row = 0; row < 3; row++) {
                gameLogic.board.insertMove(row, col, 'O');
            }

            //Then
            assertTrue(gameLogic.checkWinner('O'), "O should be winner in column " + col);
        }
    }

    @Test
    public void testOWinsInDiagonals() {
        //Given
        GameLogic gameLogic = new GameLogic();
        GameLogic gameLogic2 = new GameLogic();

        //When
        gameLogic.board.insertMove(0, 0, 'O');
        gameLogic.board.insertMove(1, 1, 'O');
        gameLogic.board.insertMove(2, 2, 'O');

        gameLogic2.board.insertMove(0, 2, 'O');
        gameLogic2.board.insertMove(1, 1, 'O');
        gameLogic2.board.insertMove(2, 0, 'O');

        //Then
        assertTrue(gameLogic.checkWinner('O'), "O should be winner in diagonal 1");
        assertTrue(gameLogic2.checkWinner('O'), "O should be winner in diagonal 2");
    }

    @Test
    public void testXWinsInRows() {
        for (int row = 0; row < 3; row++) {
            //Given
            GameLogic gameLogic = new GameLogic();

            //When
            for (int col = 0; col < 3; col++) {
                gameLogic.board.insertMove(row, col, 'X');
            }

            //Then
            assertTrue(gameLogic.checkWinner('X'), "X should be winner in row " + row);
        }
    }

    @Test
    public void testXWinsInColumns() {
        for (int col = 0; col < 3; col++) {
            //Given
            GameLogic gameLogic = new GameLogic();

            //When
            for (int row = 0; row < 3; row++) {
                gameLogic.board.insertMove(row, col, 'X');
            }

            //Then
            assertTrue(gameLogic.checkWinner('X'), "X should be winner in column " + col);
        }
    }

    @Test
    public void testXWinsInDiagonals() {
        //Given
        GameLogic gameLogic = new GameLogic();
        GameLogic gameLogic2 = new GameLogic();

        //When
        gameLogic.board.insertMove(0, 0, 'X');
        gameLogic.board.insertMove(1, 1, 'X');
        gameLogic.board.insertMove(2, 2, 'X');

        gameLogic2.board.insertMove(0, 2, 'X');
        gameLogic2.board.insertMove(1, 1, 'X');
        gameLogic2.board.insertMove(2, 0, 'X');

        //Then
        assertTrue(gameLogic.checkWinner('X'), "X should be winner in diagonal 1");
        assertTrue(gameLogic2.checkWinner('X'), "X should be winner in diagonal 2");
    }

    @Test
    public void testTheDraw() {
        //Given
        GameLogic gameLogic = new GameLogic();

        //When
        gameLogic.board.insertMove(0, 0, 'X');
        gameLogic.board.insertMove(0, 1, 'O');
        gameLogic.board.insertMove(0, 2, 'X');
        gameLogic.board.insertMove(1, 0, 'O');
        gameLogic.board.insertMove(1, 1, 'X');
        gameLogic.board.insertMove(1, 2, 'O');
        gameLogic.board.insertMove(2, 0, 'O');
        gameLogic.board.insertMove(2, 1, 'X');
        gameLogic.board.insertMove(2, 2, 'O');

        //Then
        assertFalse(gameLogic.checkWinner('X'));
        assertFalse(gameLogic.checkWinner('O'));
    }

    @Test
    public void testMoveOutOfBounds() {
        //Given
        GameLogic gameLogic = new GameLogic();

        //When
        boolean move = gameLogic.board.insertMove(3, 0, 'X');
        boolean move2 = gameLogic.board.insertMove(0, 3, 'X');

        //Then
        assertFalse(move);
        assertFalse(move2);
    }

    @Test
    public void testMoveOnOccupiedCell() {
        //Given
        GameLogic gameLogic = new GameLogic();

        //When
        boolean move = gameLogic.board.insertMove(0, 0, 'X');
        boolean move2 = gameLogic.board.insertMove(0, 0, 'O');

        //then
        assertTrue(move);
        assertFalse(move2);
    }
}

//random
