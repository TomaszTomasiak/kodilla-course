package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            secondChallenge.probablyIWillThrowException(2.0, 0.5);
        } catch (Exception e) {
            System.out.println("Problem with error: " + e + " solved");
        } finally {
            System.out.println("The task is done");
        }
    }
}
