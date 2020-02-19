package com.kodilla.good.patterns.challenges.orders;

public class UserOrder {

    public void addProductToOrder(Product product, int orderedPieces) {

        double value = product.getProductPrice() * orderedPieces;
        value *= 100;
        value = Math.round(value);
        value /= 100;

        System.out.println("Added to users order: " + product + " pieces: " + orderedPieces + "; value:  " + value);
    }
}
