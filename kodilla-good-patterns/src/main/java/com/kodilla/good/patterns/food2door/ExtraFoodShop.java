package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop implements SupplierOrderProcessor {

    private String supplierName;
    private int supplierID;

    public ExtraFoodShop(String supplierName, int supplierID) {
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

            logistics.checkUser(orderRequest.getUser());
            informationService.orderConfirmation(orderRequest);
            deliveryService.sendProcess();
            informationService.informProcessPositive(orderRequest.getProduct().getSupplier());
            accounting.orderAccounting();

            return true;

        } else {
            informationService.informProcessNegative(orderRequest.getProduct().getSupplier());

            return false;
        }
    }
}
