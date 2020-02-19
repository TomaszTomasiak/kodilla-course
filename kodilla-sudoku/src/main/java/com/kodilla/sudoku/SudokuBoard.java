package com.kodilla.sudoku;

public class SudokuBoard {
    SudokuElement[][] boardOfElements = new SudokuElement[9][9];

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            for (int n = 0; n < 9; n++) {
                boardOfElements[i][n] = new SudokuElement(SudokuElement.EMPTY);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder printBoard = new StringBuilder("        1   2   3   4   5   6   7   8   9" + "\n \n");

        for (int i = 0; i < 9; i++) {
            printBoard.append(1 + i).append("     |");
            for (int n = 0; n < 9; n++) {
                if (boardOfElements[i][n].getValue() == SudokuElement.EMPTY) {
                    printBoard.append("   ");
                } else {
                    printBoard.append(" ");
                    printBoard.append(boardOfElements[i][n].getValue());
                    printBoard.append(" ");
                }
                printBoard.append("|");
            }
            printBoard.append("\n");
        }
        return printBoard.toString();
    }
}
