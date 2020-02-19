package com.kodilla.good.patterns.food2door;

public class Order {

    private User user;
    private Product product;
    private int quantity;
    private boolean isRealized;

    public Order(User user, Product product, int amount, boolean isRealized) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.isRealized = isRealized;
    }

    public User getUser() {
        return user;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isRealized() {
        return isRealized;
    }
}
