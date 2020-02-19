package com.kodilla.good.patterns.food2door;

public class Product {

    private String productName;
    private int productID;
    private double productPrice;
    private SupplierOrderProcessor supplier;

    public Product(String productName, int productID, double productPrice, SupplierOrderProcessor supplier) {
        this.productName = productName;
        this.productID = productID;
        this.productPrice = productPrice;
        this.supplier = supplier;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductID() {
        return productID;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public SupplierOrderProcessor getSupplier() {
        return supplier;
    }

    @Override
    public String toString() {
        return productName;
    }
}
