package com.kodilla.good.patterns.food2door;

public interface InformationFlow {

    public void orderConfirmation(OrderRequest orderRequest);

    public void deliveryConfirmation(OrderRequest orderRequest);

    public void informProcessPositive(SupplierOrderProcessor supplierOrderProcessor);

    public void informProcessNegative(SupplierOrderProcessor supplierOrderProcessor);
}

