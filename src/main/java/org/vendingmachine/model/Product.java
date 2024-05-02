package org.vendingmachine.model;

public class Product {
    private final Integer productId;
    private final String productName;
    private final double price;

    public Product(Integer productId, String productName, Double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }


}
