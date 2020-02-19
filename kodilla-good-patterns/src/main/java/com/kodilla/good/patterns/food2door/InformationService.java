package com.kodilla.good.patterns.food2door;

public class InformationService implements InformationFlow {


    public void orderConfirmation(OrderRequest orderRequest) {

        double amount = orderRequest.getProduct().getProductPrice() * orderRequest.getQuantity();
        amount *= 100;
        amount = Math.round(amount);
        amount /= 100;

        System.out.println("Potwierdzenie przyjęcia zamówienia: \n"
                + orderRequest.getProduct() + ",  " + orderRequest.getQuantity() + " szt, termin dostawy: " + orderRequest.getTermOfDelivery() + "\nWartość zamówienia: "
                + amount + " zł.");
    }

    public void deliveryConfirmation(OrderRequest orderRequest) {
        System.out.println("Przewidywana data dostawy zamówionych produktów: " + orderRequest.getTermOfDelivery());
    }

    public void informProcessPositive(SupplierOrderProcessor supplierOrderProcessor) {
        System.out.println("Otrzymaliśmy informację od dostawcy: {" + supplierOrderProcessor.getSupplierName() + "} o prawidłowej realizacji zamówienia.");
    }

    public void informProcessNegative(SupplierOrderProcessor supplierOrderProcessor) {
        System.out.println("Niestety, zlecenie nie może być zrealizowane. Dostawca  " + supplierOrderProcessor.getSupplierName() + " informuje o braku zamówionego produktu.");
    }
}
