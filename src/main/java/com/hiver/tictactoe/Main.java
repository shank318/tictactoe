package com.hiver.tictactoe;

import com.hiver.tictactoe.models.CellValue;
import com.hiver.tictactoe.models.Player;

public class Main {

        public static void main(String[] args) {
            System.out.println("Welcome to Tic-Tac-Toe.");
            Player player1 = new Player(CellValue.X);

            Player player2 = new Player(CellValue.O);

            Board board = new Board(3, 3);
            TicTacToe game = new TicTacToe(board, player1, player2);
            game.runGame();
        }

}
