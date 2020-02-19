package com.kodilla;

public class Kalkulator {

    int a = 14;
    int b = 3;
    int result;

    public void addingAAndB() {
        result = a + b;
        System.out.println("Wynik dodawania (a+b): " + result);
    }
    public void subtructBFromA() {
        result = a - b;
        System.out.println("Wynik odejmowania (a-b): " + result);
    }

    public static void main(String[] args) {
        Kalkulator kalkulator = new Kalkulator();
        kalkulator.addingAAndB();
        kalkulator.subtructBFromA();
    }
}
