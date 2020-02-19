package com.kodilla.rps;

import java.util.Scanner;

public class RpsController {

    Scanner input = new Scanner(System.in);

    String playerName;
    int playerResult = 0;
    int computerResult = 0;
    int howManyPlays;

    public void setPlayerName() {
        System.out.println("What is your name? ");
        playerName = input.nextLine().toUpperCase();
    }

    public int numberOfPlays() {
        System.out.println("How many wins we play?");
        howManyPlays = input.nextInt();
        input.nextLine();
        return howManyPlays;
    }

    public void computerWin() {
        computerResult++;
        System.out.println("Computer won this round! " + playerName + " vs COMPUTER result is: " + playerResult + " : " + computerResult);
    }

    public void playerWin() {
        playerResult++;
        System.out.println("You won this round! " + playerName + " vs COMPUTER result is: " + playerResult + " : " + computerResult);
    }

    public void draw() {
        System.out.println("DRAW. " + playerName + ":  0 points; COMPUTER: 0 points\n" +
                "Result: " + playerName + ": " + playerResult + " points, Computer: " + computerResult + " points");
    }


    public void startFromTheBeginning() {
        playerResult = 0;
        computerResult = 0;
    }

    public void computerFinalWin() {
        System.out.println("GAME OVER! \nCOMPUTER WON! \n" +
                "Final result: " + playerName + ": " + playerResult + " points, Computer: " + computerResult + " points");
    }

    public void playerFinalWin() {
        System.out.println("GAME OVER!\n" + "The winner is: " + playerName + "\n" +
                "Final result: " + playerName + ": " + playerResult + " points, COMPUTER: " + computerResult + " points");
    }

    public void gameOver() {

        if (computerResult > playerResult) {
            computerFinalWin();

        } else {
            playerFinalWin();
        }
    }
}
