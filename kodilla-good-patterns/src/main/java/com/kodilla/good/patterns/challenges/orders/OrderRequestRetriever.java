package com.kodilla.good.patterns.challenges.orders;

public class OrderRequestRetriever {

    public OrderRequest retriever() {

        User user = new User("Batman", 123456);
        Product product = new Product("Hamer", 98765, 35.60);
        int orderedPieces = 3;

        return new OrderRequest(user, product, orderedPieces);
    }
}
