package com.kodilla.patterns2.facade;

public class Item {
    private final Long produtId;
    private final double qty;

    public Item(Long produtId, double qty) {
        this.produtId = produtId;
        this.qty = qty;
    }

    public Long getProdutId() {
        return produtId;
    }

    public double getQty() {
        return qty;
    }
}
