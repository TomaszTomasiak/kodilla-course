package com.kodilla.good.patterns.food2door;

public class NewShop implements SupplierOrderProcessor {

    private String supplierName;
    private int supplierID;

    public int getSupplierID() {
        return supplierID;
    }

    public NewShop(String supplierName, int supplierID) {
        this.supplierName = supplierName;
        this.supplierID = supplierID;
    }

    Logistics logistics = new Logistics();
    DeliveryService deliveryService = new DeliveryService();
    InformationService informationService = new InformationService();
    Accounting accounting = new Accounting();

    @Override
    public boolean supplierOrderProcess(OrderRequest orderRequest) {
        logistics.checkUser(orderRequest.getUser());
        informationService.orderConfirmation(orderRequest);
        deliveryService.selfCollection(orderRequest);
        accounting.orderAccounting();

        return true;
    }

    @Override
    public String getSupplierName() {
        return supplierName;
    }
}
