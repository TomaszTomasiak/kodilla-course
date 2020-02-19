package com.kodilla.good.patterns.challenges.orders;

public class OrderConfirmation implements Communication {


    @Override
    public void sendConfirmation(User user) {
        System.out.println("Confirmation sent");
    }
}
