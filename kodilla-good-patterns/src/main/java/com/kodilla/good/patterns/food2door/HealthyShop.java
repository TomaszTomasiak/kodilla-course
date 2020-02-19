package com.kodilla.good.patterns.food2door;

public class HealthyShop implements SupplierOrderProcessor {

    private String supplierName;
    private int supplierID;

    public HealthyShop(String supplierName, int supplierID) {
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
        logistics.checkStock(orderRequest.getProduct(), orderRequest.getQuantity());
        informationService.orderConfirmation(orderRequest);

        deliveryService.sendProcess();
        informationService.informProcessPositive(orderRequest.getProduct().getSupplier());
        informationService.deliveryConfirmation(orderRequest);
        accounting.orderAccounting();

        return true;
    }
}

