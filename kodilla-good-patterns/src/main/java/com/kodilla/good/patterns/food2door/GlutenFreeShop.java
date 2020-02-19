package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop implements SupplierOrderProcessor {

    private String supplierName;
    private int supplierID;

    public GlutenFreeShop(String supplierName, int supplierID) {
        this.supplierName = supplierName;
        this.supplierID = supplierID;
    }

    Logistics logistics = new Logistics();
    DeliveryService deliveryService = new DeliveryService();
    InformationService informationService = new InformationService();
    Accounting accounting = new Accounting();

    @Override
    public String getSupplierName() {
        return supplierName;
    }

    public int getSupplierID() {
        return supplierID;
    }

    @Override
    public boolean supplierOrderProcess(OrderRequest orderRequest) {

        if (logistics.checkStock(orderRequest.getProduct(), orderRequest.getQuantity())) {

            informationService.orderConfirmation(orderRequest);
            deliveryService.selfCollection(orderRequest);
            informationService.informProcessPositive(orderRequest.getProduct().getSupplier());
            accounting.orderAccounting();

            return true;

        } else {
            informationService.informProcessNegative(orderRequest.getProduct().getSupplier());
            return false;
        }

    }

}
