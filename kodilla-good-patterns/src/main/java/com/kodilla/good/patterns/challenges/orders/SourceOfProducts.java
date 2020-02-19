package com.kodilla.good.patterns.challenges.orders;

public interface SourceOfProducts {

    public boolean productOrder(final User user, final Product product, int orderedPieces);
}
