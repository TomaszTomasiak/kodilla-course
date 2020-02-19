package com.kodilla.good.patterns.food2door;

public class OrderProcessor {

    public Order realizeOrder(OrderRequest orderRequest) {
        boolean isRealized = orderRequest.getProduct().getSupplier().supplierOrderProcess(orderRequest);
        return new Order(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQuantity(), isRealized);
    }
}
