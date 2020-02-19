package com.kodilla.rps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GameRPS extends RpsController {

    public GameRPS() {

        RpsController rpsController = new RpsController();
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        HashMap<String, Move> theMap = new HashMap<>();
        theMap.put("1", new Paper());
        theMap.put("2", new Scissors());
        theMap.put("3", new Rock());
        theMap.put("4", new Lizard());
        theMap.put("5", new Spock());

        ArrayList<Move> theList = new ArrayList<>();
        theList.add(new Paper());
        theList.add(new Paper());
        theList.add(new Paper());
        theList.add(new Paper());
        theList.add(new Scissors());
        theList.add(new Scissors());
        theList.add(new Rock());
        theList.add(new Rock());
        theList.add(new Lizard());
        theList.add(new Lizard());
        theList.add(new Spock());
        theList.add(new Spock());

        boolean end = false;

        System.out.println("Paper, Scissors, Rock, Lizard, Spock - Welcome to the game");
        rpsController.setPlayerName();

        while (!end) {

            rpsController.numberOfPlays();
            System.out.println("You choose name: " + rpsController.playerName);
            System.out.println("We play up to " + rpsController.howManyPlays + " wins");

            while (!end) {
                System.out.println("Select: 1 - paper; 2 - scissors; 3 - stone; 4 - lizard; 5 - spock or X - to close the game; N -to start new game");
                String playerChoice = input.nextLine().toUpperCase();
                Move playerMove = theMap.get(playerChoice);

                if (playerChoice.equals("X")) {
                    System.out.println("Do you realy want to exit the game? Press: Y - yes or N - no");
                    playerChoice = input.nextLine().toUpperCase();

                    if (playerChoice.equals("Y")) {
                        System.out.println("Application is closed");
                        end = true;
                    } else {
                        continue;
                    }

                } else if (playerChoice.equals("N")) {
                    System.out.println("Do you realy want to terminate this game? Press: Y - yes or N - no");
                    playerChoice = input.nextLine().toUpperCase();

                    if (playerChoice.equals("Y")) {
                        rpsController.startFromTheBeginning();
                        break;

                    } else {
                        continue;
                    }

                } else if (playerChoice.equals("1") || playerChoice.equals("2") || playerChoice.equals("3") || playerChoice.equals("4")|| playerChoice.equals("5")) {

                    System.out.println("Your choice: " + playerMove.name());

                    int computerChoice = random.nextInt(12);
                    Move computerMove = theList.get(computerChoice);
                    System.out.println("Computer choice: " + computerMove.name());

                    RoundResult roundResult = playerMove.winsWith(computerMove);

                    if (roundResult.isDraw()) {
                        rpsController.draw();

                    } else if (roundResult.isWin()) {
                        rpsController.playerWin();
                        if (rpsController.computerResult == rpsController.howManyPlays || rpsController.playerResult == rpsController.howManyPlays) {
                            rpsController.gameOver();
                            end = true;
                        } else {
                            continue;
                        }

                    } else {
                        rpsController.computerWin();
                        if (rpsController.computerResult == rpsController.howManyPlays || rpsController.playerResult == rpsController.howManyPlays) {
                            rpsController.gameOver();
                            end = true;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }
}


