package com.hiver.tictactoe;

import com.hiver.tictactoe.models.Cell;
import com.hiver.tictactoe.models.CellValue;
import com.hiver.tictactoe.models.WINENUMS;

public class Board {

    private final int max_x;
    private final int max_y;
    private final int[][] board;

    public Board(int max_x, int max_y) {
        if (max_y <= 0) {
            throw new IllegalArgumentException("A TicTacToe board must have >0 rows.");
        }
        if (max_x <= 0) {
            throw new IllegalArgumentException("A TicTacToe board must have >0 cols.");
        }
        this.max_y = max_y;
        this.max_x = max_x;
        board = new int[max_y][max_x];
    }

    private void validateRowCol(int x, int y) {
        if (y < 0 || y >= max_y) {
            throw new IllegalArgumentException("Illegal row argument: " + y
                    + ". Row must be between 0 and " + (max_y - 1));
        }
        if (x < 0 || x >= max_x) {
            throw new IllegalArgumentException("Illegal col argument: " + x
                    + ". Col must be between 0 and " + (max_x - 1));
        }
    }

    public void setCell(Cell cell,CellValue value) {
        validateRowCol(cell.getY(), cell.getX());
        board[cell.getX()][cell.getY()] = value.valueToInt();;
    }

    public CellValue getCell(Cell cell) {
        validateRowCol(cell.getY(), cell.getX());
        return CellValue.intToValue(board[cell.getX()][cell.getY()]);
    }

    WINENUMS isWinningConfig() {
        WINENUMS w = WINENUMS.WIN;
        // rows
        for (int i = 0; i < max_y; i++) {
            if ((board[i][0] != 0) && (board[i][0] == board[i][1])
                    && (board[i][0] == board[i][2])) {
                return w;
            }
        }
        // columns
        for (int i = 0; i < max_x; i++) {
            if ((board[0][i] != 0) && (board[0][i] == board[1][i])
                    && (board[0][i] == board[2][i])) {
                return w;
            }
        }
        if ((board[0][0] != 0) && (board[0][0] == board[1][1])
                && (board[0][0] == board[2][2])) {
            return w;
        }

        if ((board[2][0] != 0) && (board[2][0] == board[1][1])
                && (board[2][0] == board[0][2])) {
            return w;
        }

        // draw
        w = WINENUMS.DRAW;
        for (int i = 0; i < max_y; i++)
            for (int j = 0; j < max_x; j++) {
                if (board[i][j] == 0)
                    w = WINENUMS.N;
            }
        return w;
    }

}
