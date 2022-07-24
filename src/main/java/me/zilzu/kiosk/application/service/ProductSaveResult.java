package me.zilzu.kiosk.application.service;

public class ProductSaveResult {
    public String productName;
    public String category;
    public Integer price;

    public ProductSaveResult(String productName, String category, Integer price) {
        this.productName = productName;
        this.category = category;
        this.price = price;
    }
}
