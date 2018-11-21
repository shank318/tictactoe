package com.hiver.tictactoe;

import com.hiver.tictactoe.models.Cell;
import com.hiver.tictactoe.models.CellValue;
import com.hiver.tictactoe.models.Player;
import com.hiver.tictactoe.models.WINENUMS;

import java.util.Scanner;

public class TicTacToe {

    private Board board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;

    TicTacToe(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
    }

    boolean setMove(Cell cell, CellValue p_type) {
        if (board.getCell(cell) == p_type.N) {
            board.setCell(cell, p_type);
            return true;
        } else {
            System.out.println("Invalid move");
            return false;
        }
    }

    void runGame() {
        Scanner s = new Scanner(System.in);
        int x = 0, y = 0;
        do {
            System.out.println(currentPlayer.getPlayer_type().equals(CellValue.X) ? "Player 1 turn" : "Player 2 turn");
            System.out.println("Enter x and y places");
            x = s.nextInt();
            y = s.nextInt();
            if (currentPlayer.getPlayer_type().equals(CellValue.X)) {
                Cell cell = new Cell(x, y);
                if (setMove(cell, CellValue.X)) {
                    currentPlayer = player2;
                }
                System.out.println("_____________________________");
                if ((board.isWinningConfig()) == WINENUMS.WIN) {
                    System.out.println("Player 1 WINS");
                    break;
                }


            } else if (currentPlayer.getPlayer_type().equals(CellValue.O)) {
                Cell cell = new Cell(x, y);
                if (setMove(cell, CellValue.O)) {
                    currentPlayer = player1;
                }
                System.out.println("_____________________________");
                if ((board.isWinningConfig()) == WINENUMS.WIN) {
                    System.out.println("Player 2 WINS");
                    break;
                }
            }

            if (board.isWinningConfig() == WINENUMS.DRAW) {
                System.out.println("Well played. It is a draw!");
                break;
            }


        } while (board.isWinningConfig() == WINENUMS.N);
    }
}
