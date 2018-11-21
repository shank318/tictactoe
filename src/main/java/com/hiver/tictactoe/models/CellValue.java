package com.hiver.tictactoe.models;

public enum CellValue {
    N,X,O;

    public int valueToInt() {
        if (this == N) {
            return 0;
        }
        if (this == O) {
            return 1;
        }
        return 2;
    }

    public static CellValue intToValue(int x) {
        if (x == 0) {
            return N;
        }
        if (x == 1) {
            return O;
        }
        return X;
    }
}
