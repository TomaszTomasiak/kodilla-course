package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuController {
    Scanner sc = new Scanner(System.in);
    SudokuBoard board;

    public void solveSudoku() {
        if (!backtrackSolve()) {
            System.out.println("This sudoku can't be solved");
            startNewGame();
        }
    }

    public boolean isPossibleToPutHere(int r, int c, int value) {
        for (int j = 0; j < 9; j++) {
            if (alreadyHasValue(r, j, value)) {
                return false;
            }
            for (int i = 0; i < 9; i++) {
                if (alreadyHasValue(i, c, value)) {
                    return false;
                }
                if (i < 3 && j < 3) {
                    int boxRow = r - r % 3;
                    int boxColumn = c - c % 3;
                    if (alreadyHasValue(boxRow + i, boxColumn + j, value)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean alreadyHasValue(int row, int column, int value) {
        return board.boardOfElements[row][column].getValue() == value;
    }

    private void isSudokuElementEmpty(int rowIndex, int columnIndex) {
        for (int i = 0; i < 9;  i++) {
            for (int j = 0; j < 9; j++) {
                if (board.boardOfElements[i][j].getValue() == SudokuElement.EMPTY) {
                    rowIndex = i;
                    columnIndex = j;
                }
            }
        }
    }

    public boolean backtrackSolve() {
        int columnIndex = 0;
        int rowIndex = 0;
        boolean isEmptyField = false;

        for (int i = 0; i < 9 && !isEmptyField; i++) {
            for (int j = 0; j < 9 && !isEmptyField; j++) {
                if (board.boardOfElements[i][j].getValue() == SudokuElement.EMPTY) {
                    rowIndex = i;
                    columnIndex = j;
                    isEmptyField = true;
                }
            }
        }

        if (!isEmptyField) {
            return true;
        }

        for (int possibleValue = 1; possibleValue <= 9; possibleValue++) {
            if (isPossibleToPutHere(rowIndex, columnIndex, possibleValue)) {
                board.boardOfElements[rowIndex][columnIndex].setValue(possibleValue);
                if (backtrackSolve()) {
                    return true;
                }
                board.boardOfElements[rowIndex][columnIndex].setValue(SudokuElement.EMPTY);
            }
        }
        return false;
    }



    public String menu() {
        return "SUDOKU\n" +
                "To insert digit into Sudoku board \n" +
                "type 3 digits (example: 123, where: 1 is row index, 2 is column index, 3 is number) \n" +
                "Other options:\n" +
                "sudoku - to solve Sudoku\n" +
                "n - to start a new game\n" +
                "x - to exit the game";
    }

    public UserChoice getUserChoice() {
        String input = sc.nextLine();
        boolean isDigits = input.chars().allMatch(Character::isDigit);
        boolean digitsCorrectLength = input.length() == 3;

        switch (input.toLowerCase()) {
            case "sudoku":
                return new UserChoice(UserChoiceType.RESOLVE);
            case "n":
                return new UserChoice(UserChoiceType.NEW_GAME);
            case "x":
                return new UserChoice(UserChoiceType.EXIT);

            default:
                if (isDigits && digitsCorrectLength) {
                    char setColumn = input.charAt(1);
                    char setRow = input.charAt(0);
                    char setValue = input.charAt(2);
                    int column = setColumn - 48;
                    int row = setRow - 48;
                    int value = setValue - 48;

                    if (isPossibleToPutHere(row, column, value)) {
                        return new UserChoice(column, row, value);
                    } else {
                        System.out.println("You can not put the number: " + value + " here! Try a different number");
                        return new UserChoice(UserChoiceType.NONE);
                    }
                } else {
                    return new UserChoice(UserChoiceType.NONE);
                }
        }
    }

    public void startNewGame() {

        System.out.println("Do you want to start a new game? Y/N");
        String input = sc.nextLine().toUpperCase();

        if (input.equals("Y")) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board.boardOfElements[i][j].setValue(SudokuElement.EMPTY);
                }
            }
            board = new SudokuBoard();
            resolveSudoku();
        }
        if (input.equals("N")) {
            exitGame();
        }
    }

    public void exitGame() {
        boolean isCorrect = false;
        while (!isCorrect) {
            System.out.println("Do you want exit? Y/N");
            String input = sc.nextLine().toUpperCase();

            if (input.equals("Y")) {
                sc.close();

                isCorrect = true;

            } else if (input.equals("N")) {
                isCorrect = true;
            }
        }
    }

    public boolean resolveSudoku() {
        boolean finishGame = false;
        board = new SudokuBoard();
        show(board.toString());
        show(menu() + "\n");
        while (!finishGame) {
            UserChoice choice = getUserChoice();
            switch (choice.getChoiceType()) {
                case EXIT:
                    exitGame();
                    finishGame = true;
                    break;
                case NONE:
                    break;
                case NEW_GAME:
                    startNewGame();
                    break;
                case SET_VALUE:
                    setValue(choice);
                    show(board.toString());
                    show(menu() + "\n");
                    break;
                case RESOLVE:
                    solveSudoku();
                    show(board.toString());
                    startNewGame();
                    break;
            }
        }
        return true;
    }

    public void setValueToSudokuElement(int column, int row, int value) {
        if (!canSetValue(column, row, value)) {
            System.out.println("Incorrect value " + value + " in row " + row + " column " + column);
        }
        board.boardOfElements[column][row].setValue(value);
    }

    private void setValue(UserChoice choice) {
        int column = choice.getColumn() - 1;
        int row = choice.getRow() - 1;
        int value = choice.getValue();

        try {
            setValueToSudokuElement(column, row, value);
        } catch (Exception e) {
            SudokuController.printIncorrectValueToSet(choice);
        }
    }

    public static void printIncorrectValueToSet(UserChoice choice) {
        System.out.println("Incorrect value: " + choice);
    }

    public static void show(String text) {
        System.out.println(text);
    }

    private boolean canSetValue(int column, int row, int value) {
        boolean correctValue = value >= 1 && value <= 9;
        return correctValue && correctColumnAndRow(column, row);
    }

    private boolean correctColumnAndRow(int column, int row) {
        boolean correctColumn = column >= 1 && column <= 9;
        boolean correctRow = row >= 1 && row <= 9;
        return correctColumn && correctRow;
    }
}
