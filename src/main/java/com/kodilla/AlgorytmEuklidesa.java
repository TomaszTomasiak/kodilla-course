package com.kodilla;

public class AlgorytmEuklidesa {

    public static void main(String[] args) {

        int a = 3;
        int b = 17;

        while (a >= b) {

            int rest = a % b;

            if (rest != 0) {
                a = b;
                b = rest;

            } else {
                a = b;
                break;
            }
        }

        while (a < b) {

            int rest = b % a;
            if (rest != 0) {
                b = a;
                a = rest;

            } else {
                break;
            }
        }
        System.out.println("Największym dzielnikiem jest liczba: " + a);
    }
}
