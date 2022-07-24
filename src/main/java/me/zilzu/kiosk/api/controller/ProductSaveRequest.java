package me.zilzu.kiosk.api.controller;

public class ProductSaveRequest {
    public String productName;
    public String category;
    public Integer price;

    public ProductSaveRequest(String productName, String category, Integer price) {
        this.productName = productName;
        this.category = category;
        this.price = price;
    }
}
