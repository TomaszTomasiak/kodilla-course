package com.kodilla.good.patterns.food2door;

public interface SupplierOrderProcessor {

    public boolean supplierOrderProcess(OrderRequest orderRequest);

    public String getSupplierName();
}
