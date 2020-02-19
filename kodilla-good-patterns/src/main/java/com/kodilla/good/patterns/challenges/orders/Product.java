package com.kodilla.good.patterns.challenges.orders;

public class Product {

    private String productName;
    private int productID;
    private double productPrice;

    public Product(String productName, int productID, double productPrice) {
        this.productName = productName;
        this.productID = productID;
        this.productPrice = productPrice;
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

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productID=" + productID +
                ", productPrice=" + productPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productID != product.productID) return false;
        if (Double.compare(product.productPrice, productPrice) != 0) return false;
        return productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productName.hashCode();
        result = 31 * result + productID;
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
