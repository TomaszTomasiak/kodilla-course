package com.kodilla.good.patterns.food2door;

public class DeliveryService {

    public void sendProcess() {
        System.out.println("Zamówienie zostało przekazane do dostawcy");
    }

    public void selfCollection(OrderRequest orderRequest) {
        System.out.println("Informujemy, że zamówione produkty są gotowe do odbioru z magazynu dostawcy: " + orderRequest.getProduct().getSupplier());
    }
}
