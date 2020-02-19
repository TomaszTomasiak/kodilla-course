package com.kodilla.good.patterns.challenges.orders;

public class OrderRequest {
    private User user;
    private int orderedPieces;
    private Product product;

    public OrderRequest(User user, Product product, int orderedPieces) {
        this.user = user;
        this.orderedPieces = orderedPieces;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public int getOrderedPieces() {
        return orderedPieces;
    }

    public Product getProduct() {
        return product;
    }
}
