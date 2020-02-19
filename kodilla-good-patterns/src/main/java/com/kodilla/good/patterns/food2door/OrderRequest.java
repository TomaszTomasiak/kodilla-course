package com.kodilla.good.patterns.food2door;

import java.time.LocalDate;

public class OrderRequest {

    private User user;
    private Product product;
    private int quantity;
    private LocalDate termOfDelivery;

    public OrderRequest(User user, Product product, int quantity, LocalDate termOfDelivery) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.termOfDelivery = termOfDelivery;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getTermOfDelivery() {
        return termOfDelivery;
    }
}
